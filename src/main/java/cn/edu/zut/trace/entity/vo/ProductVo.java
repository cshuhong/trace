package cn.edu.zut.trace.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class ProductVo {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("产品id")
    private String productId;
    @ApiModelProperty("NFC编号")
    private String tagId;
    @ApiModelProperty("生产公司id")
    private String manufacturerId;
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("产品介绍")
    private String productIntroduce;
    @ApiModelProperty("生产日期")
    private String productDate;
    @ApiModelProperty("生产批次")
    private String productBatch;
    @ApiModelProperty("保质期X月")
    private String productPeriod;
    @ApiModelProperty("物流公司id")
    private String transporterId;
    @ApiModelProperty("物流公司写入时间")
    private String productTdate;
    @ApiModelProperty("接收商id")
    private String hospitalId;
    @ApiModelProperty("接收时间")
    private String productHdate;
    @ApiModelProperty("产品状态")
    private String productStatus;
}
