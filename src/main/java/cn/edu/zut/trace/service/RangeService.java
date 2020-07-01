package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Range;
import com.github.pagehelper.PageInfo;


public interface RangeService {
//    查询所有标签使用范围
    PageInfo<Range> queryAllRange(int pageNo, int pageSize);

//    条件查询标签使用范围
    PageInfo<Range> queryRange(Range range, int pageNo, int pageSize);

//    标签使用范围申请
    Integer addRange(Range range);

//    修改范围审核状态
    Integer updateRange(Range range);

//    删除标签范围
    Integer deleteRange(String rangeId);
}
