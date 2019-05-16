package com.pastry.utils.result;

/**
 * Created by wulidan on 19/5/3.
 */
public class PageResult <T> {
    private Integer code;
    private String msg;
    private Integer count;
    private Boolean success;
    private T Data;

    public PageResult() {
        this.code = 0;
        this.success = true;
    }

    public PageResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
