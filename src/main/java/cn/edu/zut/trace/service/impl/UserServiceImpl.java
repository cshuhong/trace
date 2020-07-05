package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.common.util.Md5Util;
import cn.edu.zut.trace.entity.po.User;
import cn.edu.zut.trace.mapper.UserMapper;
import cn.edu.zut.trace.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String register(User user) {
        String password = Md5Util.encode(user.getUserPassword());
        user.setUserPassword(password);
        userMapper.addUser(user);
        return user.getUserId();
    }

    @Override
    public User login(User user) {
        user.setUserPassword(Md5Util.encode(user.getUserPassword()));
        List<User> users = userMapper.queryUser(user);
        if(users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public PageInfo<User> queryAllUser(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.queryAll();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<User> queryUser(User user, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.queryUser(user);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<User> queryCompanyUser(User user, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.queryCompanyUser(user);
        return new PageInfo<>(list);
    }

    @Override
    public Integer updateUser(User user) {
        if (StringUtils.isNotBlank(user.getUserPassword())){
            user.setUserPassword(Md5Util.encode(user.getUserPassword()));
        }
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(String userId) {
        return userMapper.deleteUser(userId);
    }
}
