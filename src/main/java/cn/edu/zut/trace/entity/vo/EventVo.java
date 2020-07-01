package cn.edu.zut.trace.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;


@Data
public class EventVo {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("事件id")
    private String eventId;
    @ApiModelProperty("操作的NFC编号")
    private String tagId;
    @ApiModelProperty("操作人员id")
    private String userId;
    @ApiModelProperty("事件时间")
    private String eventDate;
    @ApiModelProperty("事件发生地点")
    private String eventLocation;
    @ApiModelProperty("鉴权是否成功")
    private String eventStatus;
}
