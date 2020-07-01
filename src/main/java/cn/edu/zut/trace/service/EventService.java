package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Event;
import cn.edu.zut.trace.entity.vo.EventVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EventService {

//    查询所有追溯记录
    PageInfo<EventVo> queryAllEvent(int pageNo, int pageSize);

//    查询本企业产品的追溯记录
    PageInfo<EventVo> queryCompanyEvent(String companyId, int pageNo, int pageSize);

//    条件查询追溯记录
    PageInfo<EventVo> queryEvent(Event event, int pageNo, int pageSize);

//    添加追溯记录
    Integer addEvent(Event event);

//    更新追溯记录
    Integer updateEvent(Event event);
}
