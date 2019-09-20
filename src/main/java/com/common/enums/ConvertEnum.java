package com.common.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/15 16:10
 * @Email: 15290810931@163.com
 */
public enum ConvertEnum {

    UPPER("upper","大写"),
    LOWER("lower","小写");

    private String code;
    private String msg;

    ConvertEnum(String code, String msg) {
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
