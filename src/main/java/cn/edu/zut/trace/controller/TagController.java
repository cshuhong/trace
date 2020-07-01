package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.Tag;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.TagService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tag")
@Api(tags = "标签接口")
@CrossOrigin
public class TagController {
    private TagService tagService;

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    @ApiOperation(value = "查询所有标签", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllTag(@ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                             @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                             HttpServletResponse response) {
        PageInfo<Tag> pageInfo = tagService.queryAll(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询标签", response = R.class)
    @GetMapping("/query")
    public R queryTag(@ApiParam(name = "标签", required = true) Tag tag,
                          @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                          @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                          HttpServletResponse response) {
        PageInfo<Tag> pageInfo = tagService.queryTag(tag,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "更新标签信息", response = R.class)
    @PostMapping("/update")
    public R updateTag(@ApiParam(name = "标签", required = true) Tag tag) {
        Integer res = tagService.updateTag(tag);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "添加标签", response = R.class)
    @PostMapping("/add")
    public R addTag(@ApiParam(name = "标签", required = true) Tag tag) {
        tag.setTagStatus("0");
        Integer res = tagService.addTag(tag);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "删除标签", response = R.class)
    @PostMapping("/delete")
    public R deleteTag(@ApiParam(name = "标签id", required = true) String tagId) {
        Integer res = tagService.deleteTag(tagId);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
