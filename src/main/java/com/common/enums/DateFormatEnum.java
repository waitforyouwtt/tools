package com.common.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:37
 * @Email: 15290810931@163.com
 */
public enum DateFormatEnum {
    BLANK_FORMAT(1,"yyyy MM dd hh mm ss"),
    YYYY_MM_DD_HH_MM_SS(2,"yyyy-MM-dd hh:mm:ss"),
    YY_MM_DD_HH_MM_SS(3,"yyyy/MM/dd hh:mm:ss"),
    YY_MM_DD_HH_MM_SS2(4,"MMddHHmmss");

    private Integer code;
    private String msg;

    DateFormatEnum(Integer code, String msg) {
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
