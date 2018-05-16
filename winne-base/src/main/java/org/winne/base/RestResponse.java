package org.winne.base;

import java.util.Map;

/**
 * rest接口返回对象
 */
public class RestResponse<T> {

    //业务对应
    private T data;

    //响应状态
    private ResponseStatus status;

    //消息
    private Map<String, Object> msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, Object> msg) {
        this.msg = msg;
    }
}
