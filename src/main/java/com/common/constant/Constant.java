package com.common.constant;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:58
 * @Email: 15290810931@163.com
 */
public class Constant {

    public static final char[] NUMBER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static final int[] INT_NUMBER_ARRAY = {0,1,2,3,4,5,6,7,8,9};

    public static final char[] SMALL_KEY = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static final char[] BIG_KEY = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static final char[] COMBINATION_KEY = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    //汉语中数字大写
    public static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖" };

    //汉语中货币单位大写，这样的设计类似于占位符
    public static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟" };

    //特殊字符：整
    public static final String CN_FULL = "";
    //特殊字符：负
    public static final String CN_NEGATIVE = "负";
    //金额的精度，默认值为2
    public static final int MONEY_PRECISION = 2;
    //特殊字符：零元整
    public static final String CN_ZEOR_FULL = "零元" + Constant.CN_FULL;
}
