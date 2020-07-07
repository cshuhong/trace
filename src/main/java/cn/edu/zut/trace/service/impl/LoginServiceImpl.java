package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Login;
import cn.edu.zut.trace.entity.vo.LoginVo;
import cn.edu.zut.trace.mapper.LoginMapper;
import cn.edu.zut.trace.service.LoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<LoginVo> queryAllLogin(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<LoginVo> list = loginMapper.queryAllLogin();
        return new PageInfo<>(list);
    }
}
