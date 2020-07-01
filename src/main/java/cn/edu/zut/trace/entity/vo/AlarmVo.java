package cn.edu.zut.trace.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class AlarmVo {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("报警id")
    private String alarmId;
    @ApiModelProperty("NFC编号")
    private String tagId;
    @ApiModelProperty("报警用户id")
    private String userId;
    @ApiModelProperty("报警详细信息")
    private String alarmInformation;
    @ApiModelProperty("报警所在地")
    private String alarmLocation;
    @ApiModelProperty("报警时间")
    private String alarmDate;
}
