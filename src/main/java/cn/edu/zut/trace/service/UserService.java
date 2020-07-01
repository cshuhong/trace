package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.User;
import com.github.pagehelper.PageInfo;


public interface UserService {
//    用户注册
    String register(User user);

//    用户登录
    User login(User user);

//    查询所有用户
    PageInfo<User> queryAllUser(int pageNo, int pageSize);

//    查询用户
    PageInfo<User> queryUser(User user, int pageNo, int pageSize);

//    更新用户信息
    Integer updateUser(User user);

//    删除用户
    Integer deleteUser(String userId);
}
