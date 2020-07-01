package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Event;
import cn.edu.zut.trace.entity.vo.EventVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EventMapper extends Mapper<Event> {
    List<EventVo> queryCompanyEvent(@Param("companyId") String companyId);

    List<EventVo> queryAllEvent();

    List<EventVo> queryEvent(@Param("event") Event event);

    Integer addEvent(@Param("event") Event event);

    Integer updateEvent(@Param("event") Event event);
}
