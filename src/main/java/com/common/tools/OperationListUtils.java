package com.common.tools;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 11:31
 * @Email: 15290810931@163.com
 */
public class OperationListUtils {

    /**
     * 集合去重,返回去重后的数据
     * @param sourceList
     * @return
     */
    public static List<String> distinctList(List<String> sourceList){
        return sourceList.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 返回集合中的重复数据
     * @param stream
     * @return
     */
    public static <T> List<T> repeatList(Stream<T> stream){
        return stream.collect(Collectors.toMap(e ->e,e->1,(a,b) -> a + b))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey()).collect(Collectors.toList());
    }

    /**
     * 判断集合是否有重复数据
     * @param sourceList
     * @return
     */
    public static boolean isRepeat(List<String> sourceList){
        long count = sourceList.stream().distinct().count();
        boolean isRepeat = count < sourceList.size();
        if (isRepeat){
            return true;
        }else{
            return false;
        }
    }
}
