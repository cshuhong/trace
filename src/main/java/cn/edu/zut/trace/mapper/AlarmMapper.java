package cn.edu.zut.trace.mapper;

import cn.edu.zut.trace.entity.po.Alarm;
import cn.edu.zut.trace.entity.vo.AlarmVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AlarmMapper extends Mapper<Alarm> {
//    查询对本企业产品报警的数据
    List<AlarmVo> queryCompanyAlarm(@Param("companyId") String companyId);

    List<AlarmVo> queryAllAlarm();

    List<AlarmVo> queryAlarm(@Param("alarm") Alarm alarm);

    Integer addAlarm(@Param("alarm") Alarm alarm);

    Integer updateAlarm(@Param("alarm") Alarm alarm);
}
