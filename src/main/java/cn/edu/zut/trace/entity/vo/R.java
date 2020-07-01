package cn.edu.zut.trace.entity.vo;

import cn.edu.zut.trace.common.enums.ResultCode;
import lombok.Data;

@Data
public class R {
    private Integer code;
    private String msg;
    private Object data;

    public R(ResultCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public R(ResultCode code, Object data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }
}
