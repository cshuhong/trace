package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class Product {
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
    private Timestamp productDate;
    @ApiModelProperty("生产批次")
    private String productBatch;
    @ApiModelProperty("保质期X月")
    private String productPeriod;
    @ApiModelProperty("物流公司id")
    private String transporterId;
    @ApiModelProperty("物流公司写入时间")
    private Timestamp productTdate;
    @ApiModelProperty("接收商id")
    private String hospitalId;
    @ApiModelProperty("接收时间")
    private Timestamp productHdate;
    @ApiModelProperty("产品状态")
    private String productStatus;

    public Product(String tagId, String manufacturerId, String productStatus) {
        this.tagId = tagId;
        this.manufacturerId = manufacturerId;
        this.productStatus = productStatus;
    }

    public Product(String tagId, String transporterId, Timestamp productTdate, String hospitalId, Timestamp productHdate) {
        this.tagId = tagId;
        this.transporterId = transporterId;
        this.productTdate = productTdate;
        this.hospitalId = hospitalId;
        this.productHdate = productHdate;
    }

    public Product(String productId, String tagId, String manufacturerId, String productName, String productIntroduce, Timestamp productDate, String productBatch, String productPeriod, String transporterId, Timestamp productTdate, String hospitalId, Timestamp productHdate, String productStatus) {
        this.productId = productId;
        this.tagId = tagId;
        this.manufacturerId = manufacturerId;
        this.productName = productName;
        this.productIntroduce = productIntroduce;
        this.productDate = productDate;
        this.productBatch = productBatch;
        this.productPeriod = productPeriod;
        this.transporterId = transporterId;
        this.productTdate = productTdate;
        this.hospitalId = hospitalId;
        this.productHdate = productHdate;
        this.productStatus = productStatus;
    }

    public Product() { }
}
