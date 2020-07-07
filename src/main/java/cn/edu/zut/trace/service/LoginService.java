package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Login;
import cn.edu.zut.trace.entity.vo.LoginVo;
import com.github.pagehelper.PageInfo;

public interface LoginService {
//    添加登录统计
    Integer addLogin(Login login);

//    查询所有登录统计
    PageInfo<LoginVo> queryAllLogin(int pageNo, int pageSize);
}
