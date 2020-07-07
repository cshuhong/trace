package cn.edu.zut.trace.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class Login {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    private String loginId;
    @ApiModelProperty("登录时间")
    private Timestamp loginTime;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("账号")
    private String userAccount;
    @ApiModelProperty("所属公司id")
    private String companyId;
    @ApiModelProperty("身份")
    private String userIdentity;

    public Login(String loginId, Timestamp loginTime, String userId, String userName, String userAccount, String companyId, String userIdentity) {
        this.loginId = loginId;
        this.loginTime = loginTime;
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.companyId = companyId;
        this.userIdentity = userIdentity;
    }

    public Login() { }
}
