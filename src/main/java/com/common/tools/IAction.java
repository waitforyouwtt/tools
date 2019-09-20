package com.common.tools;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:50
 * @Email: 15290810931@163.com
 */
@FunctionalInterface
public interface IAction<T> {
    void run(T param);
}
