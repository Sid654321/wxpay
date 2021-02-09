package com.sst.utils;

public enum Code {
    SUCCESS(0,"操作成功"),
    ERROR(1001,"操作失败"),
    NODATA(1002,"暂无数据"),
    LOGIN_ERROR(1003,"用户名或密码错误"),
    NOT_EMPTY(1004,"不能为空");
    Integer code;
    String msg;
    Code(Integer code, String msg){
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
}
