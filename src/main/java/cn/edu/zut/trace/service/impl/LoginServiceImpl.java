package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Login;
import cn.edu.zut.trace.mapper.LoginMapper;
import cn.edu.zut.trace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private LoginMapper loginMapper;

    @Autowired
    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public Integer addLogin(Login login) {
        return loginMapper.addLogin(login);
    }
}
