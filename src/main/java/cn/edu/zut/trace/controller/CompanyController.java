package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.Company;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.CompanyService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/company")
@Api(tags = "公司接口")
@CrossOrigin
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ApiOperation(value = "公司注册", response = R.class)
    @PostMapping("/register")
    public R register(@ApiParam(name = "公司实体类", required = true) Company company) {
        if (StringUtils.isBlank(company.getCompanyName()) || StringUtils.isBlank(company.getCompanyLocation()) ||
                StringUtils.isBlank(company.getCompanyPhone()) || StringUtils.isBlank(company.getCompanyPhoto())) {
            return new R(ResultCode.注册失败);
        }
        //判断数据库中是否已存在
        Company c = new Company();
        c.setCompanyName(company.getCompanyName());
        PageInfo<Company> pageInfo = companyService.queryCompany(c,1,10);
        if(pageInfo.getList().size()>0){
            return new R(ResultCode.重复添加);
        }
        String id = companyService.register(company);
        //注册返回id
        if (StringUtils.isNotBlank(id)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", id);
            return new R(ResultCode.成功, jsonObject);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "查询所有公司", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllCompany(@ApiParam(name = "页数", required = true) @RequestParam(defaultValue = "1") int pageNo,
                       @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                       HttpServletResponse response) {
        PageInfo<Company> pageInfo = companyService.queryAllCompany(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询公司", response = R.class)
    @GetMapping("/query")
    public R queryCompany(@ApiParam(name = "公司实体类", required = true) Company company,
                      @ApiParam(name = "页数", required = true) @RequestParam(defaultValue = "1") int pageNo,
                      @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                      HttpServletResponse response) {
        PageInfo<Company> pageInfo = companyService.queryCompany(company,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "更新公司信息", response = R.class)
    @PostMapping("/update")
    public R updateCompany(@ApiParam(name = "公司实体类", required = true) Company company) {
        Integer res= companyService.updateCompany(company);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "删除公司", response = R.class)
    @PostMapping("/delete")
    public R deleteCompany(@ApiParam(name = "公司id", required = true) String companyId) {
        Integer res= companyService.deleteCompany(companyId);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
