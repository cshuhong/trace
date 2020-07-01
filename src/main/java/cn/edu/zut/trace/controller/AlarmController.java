package cn.edu.zut.trace.controller;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.Alarm;
import cn.edu.zut.trace.entity.vo.AlarmVo;
import cn.edu.zut.trace.entity.vo.R;
import cn.edu.zut.trace.service.AlarmService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/alarm")
@Api(tags = "报警记录接口")
@CrossOrigin
public class AlarmController {
    private AlarmService alarmService;

    @Autowired
    public void setAlarmService(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @ApiOperation(value = "查询所有报警记录", response = R.class)
    @GetMapping("/queryAll")
    public R queryAllAlarm(@ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                             @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                             HttpServletResponse response) {
        PageInfo<AlarmVo> pageInfo = alarmService.queryAllAlarm(pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "条件查询报警记录", response = R.class)
    @GetMapping("/query")
    public R queryAlarm(@ApiParam(name = "报警记录实体类", required = true) Alarm alarm,
                          @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                          @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                          HttpServletResponse response) {
        PageInfo<AlarmVo> pageInfo = alarmService.queryAlarm(alarm,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(500);
            return new R(ResultCode.Http接口响应异常);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "查询公司产品的报警记录", response = R.class)
    @GetMapping("/queryCompanyAlarm")
    public R queryCompanyAlarm(@ApiParam(name = "报警记录实体类", required = true) String companyId,
                        @ApiParam(name = "页数", required = true)@RequestParam(defaultValue = "1") int pageNo,
                        @ApiParam(name = "页大小", required = true) @RequestParam(defaultValue = "10") int pageSize,
                        HttpServletResponse response) {
        PageInfo<AlarmVo> pageInfo = alarmService.queryCompanyAlarm(companyId,pageNo,pageSize);
        if (pageInfo == null) {
            response.setStatus(403);
            return new R(ResultCode.操作失败);
        }
        return new R(ResultCode.成功, pageInfo);
    }

    @ApiOperation(value = "更新报警记录", response = R.class)
    @PostMapping("/update")
    public R updateAlarm(@ApiParam(name = "报警记录实体类", required = true) Alarm alarm) {
        Integer res = alarmService.updateAlarm(alarm);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }

    @ApiOperation(value = "添加报警记录", response = R.class)
    @PostMapping("/add")
    public R addAlarm(@ApiParam(name = "报警记录实体类", required = true) Alarm alarm) {
        Integer res = alarmService.addAlarm(alarm);
        if (res > 0) {
            return new R(ResultCode.成功);
        }
        return new R(ResultCode.系统异常);
    }
}
