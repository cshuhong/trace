package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Alarm;
import cn.edu.zut.trace.entity.vo.AlarmVo;
import cn.edu.zut.trace.mapper.AlarmMapper;
import cn.edu.zut.trace.service.AlarmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {
    AlarmMapper alarmMapper;

    @Autowired
    public AlarmServiceImpl(AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    @Override
    public PageInfo<AlarmVo> queryAllAlarm(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<AlarmVo> list = alarmMapper.queryAllAlarm();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<AlarmVo> queryCompanyAlarm(String companyId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<AlarmVo> list = alarmMapper.queryCompanyAlarm(companyId);
        if (list.size()>0){
            return new PageInfo<>(list);
        }
        return null;
    }

    @Override
    public PageInfo<AlarmVo> queryAlarm(Alarm alarm, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<AlarmVo> list = alarmMapper.queryAlarm(alarm);
        return new PageInfo<>(list);
    }

    @Override
    public Integer addAlarm(Alarm alarm) {
        return alarmMapper.addAlarm(alarm);
    }

    @Override
    public Integer updateAlarm(Alarm alarm) {
        return alarmMapper.updateAlarm(alarm);
    }
}
