package cn.edu.zut.trace.service;

import cn.edu.zut.trace.entity.po.Tag;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TagService {
//    查询所有标签
    PageInfo<Tag> queryAll(int pageNo, int pageSize);

//    查询本企业所有标签
    PageInfo<Tag> queryTag(Tag tag, int pageNo, int pageSize);

//    添加标签
    Integer addTag(Tag tag);

//    修改标签状态
    Integer updateTag(Tag tag);

//    删除标签
    Integer deleteTag(String tagId);
}
