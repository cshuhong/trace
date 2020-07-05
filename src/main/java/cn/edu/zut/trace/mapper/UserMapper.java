package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    Integer addUser(@Param("user") User user);

    List<User> queryAll();

    List<User> queryUser(@Param("user") User user);

    List<User> queryCompanyUser(@Param("user") User user);

    Integer updateUser(@Param("user") User user);

    Integer deleteUser(@Param("userId") String userId);
}
