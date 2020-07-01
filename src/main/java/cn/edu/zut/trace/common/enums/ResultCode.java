package cn.edu.zut.trace.common.enums;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@SuppressWarnings("all")
@ApiModel("状态码")
public enum ResultCode {
    成功(0,"success"),
    已注册(1001,"该账号已注册"),
    注册失败(1000,"用户信息不全"),
    登录失败(2000,"用户名或密码错误"),
    账户异常(2001,"账户被禁用或正在审核，请联系管理员"),
    未登陆异常(401, "尚未登陆"),
    操作失败(-1, "操作失败"),
    系统异常(1, "系统异常,请稍后再试"),
    参数为空(2, "参数不能为空"),
    参数异常(14, "参数异常"),
    文件上传异常(4, "文件上传异常"),
    请求方式错误(5, "请求方式不支持"),
    请求路径异常(6, "请检查url是否正确"),
    权限异常(401, "权限不足"),
    数据解析异常(11, "数据解析异常"),
    Http接口响应异常(12, "数据解析异常"),
    请求凭证有误(13, "请求凭证有误");

    @Getter
    private int code;
    @Getter
    private String msg;


    ResultCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }
}
