package com.common.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:37
 * @Email: 15290810931@163.com
 */
public enum  TimeEnum {
    HOUR(1,"时"),
    MINUTE(2,"分"),
    SECOND(3,"秒");

    private Integer code;
    private String msg;

    TimeEnum(Integer code, String msg) {
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
