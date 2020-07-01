package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Range;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RangeMapper extends Mapper<Range> {

    Integer addRange(@Param("range") Range range);

    List<Range> queryAllRange(int pageNo, int pageSize);

    List<Range> queryRange(@Param("range") Range range);

    Integer updateRange(@Param("range") Range range);

    Integer deleteRange(@Param("rangeId") String rangeId);
}
