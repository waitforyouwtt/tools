package com.common.tools;

import com.common.constant.Constant;

import java.math.BigDecimal;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 11:07
 * @Email: 15290810931@163.com
 */
public class MoneyToUppercaseUtils {

    /**
     * 把输入的金额转换为汉语中人民币的大写
     *
     * @param numberOfMoney
     *            输入的金额
     * @return 对应的汉语大写
     */
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return Constant.CN_ZEOR_FULL;
        }
        //这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(Constant.MONEY_PRECISION)
                .setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, Constant.CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, Constant.CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, Constant.CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, Constant.CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, Constant.CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, Constant.CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, Constant.CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, Constant.CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(Constant.CN_FULL);
        }
        return sb.toString();
    }
}
