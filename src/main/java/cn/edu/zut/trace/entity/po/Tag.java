package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class Tag {
    @Id
    @ApiModelProperty("标签id（NFC编号）")
    private String tagId;
    @ApiModelProperty("标签所属范围")
    private String tagRange;
    @ApiModelProperty("所属企业id")
    private String companyId;
    @ApiModelProperty("标签状态")
    private String tagStatus;

    public Tag(String companyId) {
        this.companyId = companyId;
    }

    public Tag(String tagId, String tagRange, String companyId, String tagStatus) {
        this.tagId = tagId;
        this.tagRange = tagRange;
        this.companyId = companyId;
        this.tagStatus = tagStatus;
    }

    public Tag() { }
}
