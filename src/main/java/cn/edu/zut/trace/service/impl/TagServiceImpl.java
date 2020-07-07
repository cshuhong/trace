package cn.edu.zut.trace.service.impl;

import cn.edu.zut.trace.entity.po.Tag;
import cn.edu.zut.trace.mapper.TagMapper;
import cn.edu.zut.trace.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public PageInfo<Tag> queryAll(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Tag> list = tagMapper.queryAll();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Tag> queryTag(Tag tag, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Tag> list = tagMapper.queryTag(tag);
        return new PageInfo<>(list);
    }

    @Override
    public Integer addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public Integer updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public Integer deleteTag(String tagId) {
        return tagMapper.deleteTag(tagId);
    }
}
