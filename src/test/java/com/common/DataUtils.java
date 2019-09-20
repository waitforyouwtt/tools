package com.common;

import com.common.entity.UserInfo;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:54
 * @Email: 15290810931@163.com
 */
public class DataUtils {

    public static UserInfo createData(){
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setUsername("凤凰小哥哥");
        user.setPwd("24");
        return user;
    }
}
