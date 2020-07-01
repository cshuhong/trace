package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class Alarm {
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
    private Timestamp alarmDate;

    public Alarm(String alarmId, String tagId, String userId, String alarmInformation, String alarmLocation, Timestamp alarmDate) {
        this.alarmId = alarmId;
        this.tagId = tagId;
        this.userId = userId;
        this.alarmInformation = alarmInformation;
        this.alarmLocation = alarmLocation;
        this.alarmDate = alarmDate;
    }

    public Alarm() { }
}
