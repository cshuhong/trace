package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LoginMapper extends Mapper<Login> {
    Integer addLogin(@Param("login") Login login);
}
