package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Login;
import cn.edu.zut.trace.entity.vo.LoginVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface LoginMapper extends Mapper<Login> {

    Integer addLogin(@Param("login") Login login);

    List<LoginVo> queryAllLogin();
}
