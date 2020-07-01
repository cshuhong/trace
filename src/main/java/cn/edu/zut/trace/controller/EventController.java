package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.Event;
import cn.edu.zut.trace.entity.vo.EventVo;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.EventService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/event")
@Api(tags = "事件接口")
@CrossOrigin
public class EventController {
    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation(value = "查询所有追溯事件", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllEvent(@ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                             @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                             HttpServletResponse response) {
        PageInfo<EventVo> pageInfo = eventService.queryAllEvent(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询追溯事件", response = R.class)
    @GetMapping("/query")
    public R queryEvent(@ApiParam(name = "产品实体类", required = true) Event event,
                          @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                          @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                          HttpServletResponse response) {
        PageInfo<EventVo> pageInfo = eventService.queryEvent(event,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "查询公司追溯事件", response = R.class)
    @GetMapping("/queryCompanyEvent")
    public R queryCompanyEvent(@ApiParam(name = "产品实体类", required = true) String companyId,
                        @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                        @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                        HttpServletResponse response) {
        PageInfo<EventVo> pageInfo = eventService.queryCompanyEvent(companyId,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "更新追溯事件", response = R.class)
    @PostMapping("/update")
    public R updateEvent(@ApiParam(name = "追溯记录实体类", required = true) Event event) {
        Integer res = eventService.updateEvent(event);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "添加追溯事件", response = R.class)
    @PostMapping("/add")
    public R addEvent(@ApiParam(name = "追溯记录实体类", required = true) Event event) {
        Integer res = eventService.addEvent(event);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
