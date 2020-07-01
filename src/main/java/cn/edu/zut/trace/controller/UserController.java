package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.User;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
@CrossOrigin
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "用户注册", response = ResultCode.class)
    @PostMapping("/register")
    public R register(@ApiParam(name = "用户实体类", required = true) User user){
        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getUserPassword())
        || StringUtils.isBlank(user.getUserAccount()) || StringUtils.isBlank(user.getUserIdentity()) ) {
            return new R(ResultCode.注册失败);
        }
        if (StringUtils.isBlank(user.getCompanyId()))
            user.setCompanyId("0");
        //判断数据库中是否已存在
        User u = new User();
        u.setUserAccount(user.getUserAccount());
        PageInfo<User> pageInfo = userService.queryUser(u,0,0);
        if(pageInfo.getList().size()>0){
            return new R(ResultCode.已注册);
        }
        String id = userService.register(user);
        //注册返回id
        if (StringUtils.isNotBlank(id)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", id);
            return new R(ResultCode.成功, jsonObject);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "用户登录", response = ResultCode.class)
    @PostMapping("/login")
    public R login(@ApiParam(name = "用户实体类", required = true)User user,
                   HttpServletResponse response, HttpSession session){
        //判断用户名,密码是否为空
        if (StringUtils.isNotBlank(user.getUserAccount()) && StringUtils.isNotBlank(user.getUserPassword())) {
            User user1 = userService.login(user);
            if(user1!=null){
                //账户禁用
                if ("2".equals(user1.getUserStatus())||"1".equals(user1.getUserStatus())) {
                    return new R(ResultCode.账户异常);
                }
                else{
                    session.setAttribute("user",user1);
                    return new R(ResultCode.成功, user1);
                }
            }
        }
        response.setStatus(403);
        return new R(ResultCode.登录失败);
    }

    @ApiOperation(value = "查询所有用户", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllUser(@ApiParam(name = "页数", required = true) @RequestParam(defaultValue = "1") int pageNo,
                       @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                       HttpServletResponse response) {
        PageInfo<User> pageInfo = userService.queryAllUser(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询用户", response = R.class)
    @GetMapping("/query")
    public R queryUser(@ApiParam(name = "用户实体类", required = true) User user,
                       @ApiParam(name = "页数", required = true) @RequestParam(defaultValue = "1") int pageNo,
                   @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                   HttpServletResponse response) {
        PageInfo<User> pageInfo = userService.queryUser(user,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "更新用户信息", response = R.class)
    @PostMapping("/update")
    public R updateUser(@ApiParam(name = "用户实体类", required = true) User user) {
        Integer res = userService.updateUser(user);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "删除用户", response = R.class)
    @PostMapping("/delete")
    public R deleteUser(@ApiParam(name = "用户id", required = true) String userId) {
        Integer res = userService.deleteUser(userId);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
