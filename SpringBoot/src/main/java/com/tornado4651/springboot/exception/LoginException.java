package com.tornado4651.springboot.exception;

public class LoginException extends Exception {
    private Integer code;
    private String msg;

    public LoginException() {
    }

    public LoginException(Integer code, String msg) {
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
