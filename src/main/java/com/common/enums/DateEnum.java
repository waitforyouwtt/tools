package com.common.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:36
 * @Email: 15290810931@163.com
 */
public enum  DateEnum {

    YEAR(1,"年"),
    MONTH(2,"月"),
    WEEK(3,"周"),
    DAY(4,"日");

    private Integer code;
    private String msg;

    DateEnum(Integer code, String msg) {
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
