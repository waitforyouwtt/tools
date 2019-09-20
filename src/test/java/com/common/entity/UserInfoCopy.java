package com.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:51
 * @Email: 15290810931@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoCopy {
    private int id;
    private String username;
    private String pwd;

    public UserInfoCopy(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
}
