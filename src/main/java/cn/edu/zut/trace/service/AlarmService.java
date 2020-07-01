package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Alarm;
import cn.edu.zut.trace.entity.vo.AlarmVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AlarmService {
//    查询所有报警数据
    PageInfo<AlarmVo> queryAllAlarm(int pageNo, int pageSize);

//    查询对本企业产品报警数据
    PageInfo<AlarmVo> queryCompanyAlarm(String companyId, int pageNo, int pageSize);

//    条件查询报警数据
    PageInfo<AlarmVo> queryAlarm(Alarm alarm, int pageNo, int pageSize);

//    添加报警数据
    Integer addAlarm(Alarm alarm);

//    更新报警数据
    Integer updateAlarm(Alarm alarm);
}
