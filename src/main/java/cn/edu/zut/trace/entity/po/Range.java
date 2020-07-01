package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class Range {
    @Id
    @ApiModelProperty("标签范围")
    private String rangeId;
    @ApiModelProperty("所属公司id")
    private String companyId;
    @ApiModelProperty("审核状态")
    private String rangeStatus;

    public Range(String rangeId, String companyId, String rangeStatus) {
        this.rangeId = rangeId;
        this.companyId = companyId;
        this.rangeStatus = rangeStatus;
    }

    public Range() { }
}
