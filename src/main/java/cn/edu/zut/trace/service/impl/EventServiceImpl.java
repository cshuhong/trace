package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Event;
import cn.edu.zut.trace.entity.vo.EventVo;
import cn.edu.zut.trace.mapper.EventMapper;
import cn.edu.zut.trace.service.EventService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    private EventMapper eventMapper;

    @Autowired
    public EventServiceImpl(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    @Override
    public PageInfo<EventVo> queryAllEvent(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<EventVo> list =  eventMapper.queryAllEvent();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<EventVo> queryCompanyEvent(String companyId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<EventVo> list =  eventMapper.queryCompanyEvent(companyId);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<EventVo> queryEvent(Event event, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<EventVo> list =  eventMapper.queryEvent(event);
        return new PageInfo<>(list);
    }

    @Override
    public Integer addEvent(Event event) {
        return eventMapper.addEvent(event);
    }

    @Override
    public Integer updateEvent(Event event) {
        return eventMapper.updateEvent(event);
    }
}
