package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Range;
import cn.edu.zut.trace.mapper.RangeMapper;
import cn.edu.zut.trace.service.RangeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RangeServiceImpl implements RangeService {
    private RangeMapper rangeMapper;

    @Autowired
    public RangeServiceImpl(RangeMapper rangeMapper) {
        this.rangeMapper = rangeMapper;
    }

    @Override
    public PageInfo<Range> queryAllRange(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Range> list = rangeMapper.queryAllRange(pageNo,pageSize);
        return new PageInfo<>(list);
    }


    @Override
    public Integer addRange(Range range) {
        return rangeMapper.addRange(range);
    }

    @Override
    public PageInfo<Range> queryRange(Range range, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Range> list = rangeMapper.queryRange(range);
        return new PageInfo<>(list);
    }

    @Override
    public Integer updateRange(Range range) {
        return rangeMapper.updateRange(range);
    }

    @Override
    public Integer deleteRange(String rangeId) {
        return rangeMapper.deleteRange(rangeId);
    }
}
