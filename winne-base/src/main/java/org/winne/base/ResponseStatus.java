package org.winne.base;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Rest接口响应状态
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResponseStatus {

    SUCCESS("0000", "成功"),
    ERROR("0001", "服务器错误"),
    EXCEPTION("0002", "服务器异常"),
    ;

    //响应编码
    private String code;

    //响应消息
    private String msg;

    private ResponseStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
