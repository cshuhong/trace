package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("密码")
    private String userPassword;
    @ApiModelProperty("账号")
    private String userAccount;
    @ApiModelProperty("照片")
    private String userPhoto;
    @ApiModelProperty("所属公司")
    private String companyId;
    @ApiModelProperty("身份")
    private String userIdentity;
    @ApiModelProperty("状态")
    private String userStatus;

    public User(String userId, String companyId, String userIdentity, String userStatus) {
        this.userId = userId;
        this.companyId = companyId;
        this.userIdentity = userIdentity;
        this.userStatus = userStatus;
    }

    public User() { }

    public User(String userId, String userName, String userPassword, String userAccount, String userPhoto, String companyId, String userIdentity, String userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAccount = userAccount;
        this.userPhoto = userPhoto;
        this.companyId = companyId;
        this.userIdentity = userIdentity;
        this.userStatus = userStatus;
    }
}
