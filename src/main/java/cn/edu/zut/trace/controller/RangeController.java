package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.Range;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.RangeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/range")
@Api(tags = "标签范围接口")
@CrossOrigin
public class RangeController {
    private RangeService rangeService;

    @Autowired
    public void setRangeService(RangeService rangeService) {
        this.rangeService = rangeService;
    }

    @ApiOperation(value = "查询所有标签范围", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllRange(@ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                             @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                             HttpServletResponse response) {
        PageInfo<Range> pageInfo = rangeService.queryAllRange(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询范围", response = R.class)
    @GetMapping("/query")
    public R queryRange(@ApiParam(name = "标签范围实体类", required = true) Range range,
                          @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                          @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                          HttpServletResponse response) {
        PageInfo<Range> pageInfo = rangeService.queryRange(range,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "更新范围信息", response = R.class)
    @PostMapping("/update")
    public R updateRange(@ApiParam(name = "标签范围", required = true) Range range) {
        Integer res = rangeService.updateRange(range);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "申请范围", response = R.class)
    @PostMapping("/add")
    public R addRange(@ApiParam(name = "范围实体类", required = true) Range range) {
        //判断数据库中是否已存在
        Range r = new Range();
        r.setRangeId(range.getRangeId());
        PageInfo<Range> pageInfo = rangeService.queryRange(r,1,10);
        if(pageInfo.getList().size()>0){
            return new R(ResultCode.重复添加);
        }
        range.setRangeStatus("1");
        Integer res = rangeService.addRange(range);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "删除范围", response = R.class)
    @PostMapping("/delete")
    public R deleteRange(@ApiParam(name = "范围id", required = true) String rangeId) {
        Integer res = rangeService.deleteRange(rangeId);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
