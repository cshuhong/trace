package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.sql.Blob;
@Data
public class Company {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("公司id")
    private String companyId;
    @ApiModelProperty("公司名称")
    private String companyName;
    @ApiModelProperty("公司地址")
    private String companyLocation;
    @ApiModelProperty("公司电话")
    private String companyPhone;
    @ApiModelProperty("法人照片")
    private String companyPhoto;
    @ApiModelProperty("审核状态")
    private String companyStatus;

    public Company(String companyName, String companyPhone, String companyStatus) {
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyStatus = companyStatus;
    }

    public Company(String companyId) {
        this.companyId = companyId;
    }

    public Company(String companyId, String companyName, String companyLocation, String companyPhone, String companyPhoto, String companyStatus) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.companyPhone = companyPhone;
        this.companyPhoto = companyPhoto;
        this.companyStatus = companyStatus;
    }

    public Company() {
    }
}
