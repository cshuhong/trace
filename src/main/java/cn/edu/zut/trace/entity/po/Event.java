package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class Event {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("事件id")
    private String eventId;
    @ApiModelProperty("操作的NFC编号")
    private String tagId;
    @ApiModelProperty("操作人员id")
    private String userId;
    @ApiModelProperty("事件时间")
    private Timestamp eventDate;
    @ApiModelProperty("事件发生地点")
    private String eventLocation;
    @ApiModelProperty("鉴权是否成功")
    private String eventStatus;

    public Event(String tagId) {
        this.tagId = tagId;
    }

    public Event(String eventId, String tagId, String userId, Timestamp eventDate, String eventLocation, String eventStatus) {
        this.eventId = eventId;
        this.tagId = tagId;
        this.userId = userId;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventStatus = eventStatus;
    }

    public Event() { }
}
