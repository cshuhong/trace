package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TagMapper extends Mapper<Tag> {

    Integer addTag(@Param("tag") Tag tag);

    List<Tag> queryAll();

    List<Tag> queryTag(@Param("tag") Tag tag);

    Integer updateTag(@Param("tag") Tag tag);

    Integer deleteTag(@Param("tagId") String tagId);
}
