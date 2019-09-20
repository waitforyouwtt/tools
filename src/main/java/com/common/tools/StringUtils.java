package com.common.tools;

import com.common.constant.Constant;
import com.common.enums.ConvertEnum;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 13:43
 * @Email: 15290810931@163.com
 */
public class StringUtils {

    /**
     * 将第一个目标替换成第二个目标字，返回结果
     * @param var1
     * @param var2
     * @return
     */
    public static String strReplace(String var1 ,String var2){
        return  var1.replace(var1,var2);
        //result = result.replaceAll(var1,var2);
    }
    /**
     * 将目标小写变大写/小写，返回结果
     * @param target
     * @return
     */
    public static String toUpperCase(String target,String convertType){
        if (ConvertEnum.UPPER.getCode().equals(convertType)){
            target = target.toUpperCase();
        }else if(ConvertEnum.LOWER.getCode().equals(convertType)){
            target = target.toLowerCase();
        }
        return target;
    }
    /**
     * compareTo()的返回值是整型,它是先比较对应字符的大小(ASCII码顺序),
     * 如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值,
     * 如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,
     * 以此类推,直至比较的字符或被比较的字符有一方全比较完,这时就比较字符的长度.
     * @param var1
     * @param var2
     * @return int
     */
    public static int toCompareTo(String var1,String var2){
        return var1.compareTo(var2);
    }
    /**
     * 比较时不区分大小写
     * @param var1
     * @param var2
     * @return
     */
    public static int compareToIgnoreCase(String var1,String var2){
        return var1.compareToIgnoreCase(var2);
    }
    /**
     * 比较时不区分大小写
     * @param var1
     * @param var2
     * @return
     */
    public static boolean equalsIgnoreCase(String var1,String var2){
        return var1.equalsIgnoreCase(var2);
    }
    /**
     * 以空格进行拆分
     * @param target
     * @return
     */
    public static String toSplit(String target){
        String[]temp=target.split(" ");
        String result = null;
        for(int i=0;i<temp.length;i++){
            result = temp[i];
        }
        return result;
    }
    /**
     *
     * @param target
     * @param target2
     * @return
     */
    public static boolean toEquals(String target,String target2){
        return target.equals(target2);
    }
    /**
     * 返回字符串的长度
     * @param target
     * @return
     */
    public static int targetLength(String target){
        return target.length();
    }
    /**
     * 从第几位开始截取，返回截取后的结果[如果第二个参数为空]
     * 第几位开始截取，返回截取到想要的位置[第二个参数不为空]
     * @param target
     * @param length
     * @return
     */
    public static String substring(String target,Integer length,Integer length2){
        if(org.springframework.util.StringUtils.isEmpty(length2)){
            return  target.substring(length);
        }else{
            return target.substring(length,length2);
        }
    }
    /**
     * 目标是否以条件开头
     * @param target
     * @param target2
     * @return
     */
    public static boolean startsWith(String target,String target2){
        return  target.startsWith(target2);
    }
    /**
     * 目标是否以条件结尾
     * @param target
     * @param target2
     * @return
     */
    public static boolean endsWith(String target,String target2){
        return  target.endsWith(target2);
    }
    /**
     * 返回目标的第N位字符
     * @param target
     * @param target2
     * @return
     */
    public static char charAt(String target,Integer target2){
        return  target.charAt(target2);
    }

    /**
     * 拼接字符串
     * @param target
     * @param target2
     * @return
     */
    public static String concat(String target,String target2){
        return  target.concat(target2);
    }
    /**
     * 总计汉字个数
     */
    public static int  countChinaWord(String str){
        String regex = "[\u4e00-\u9fa5]";
        // 定义一个列表用于存放找到的中文
        ArrayList<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);// 定义模式，（模具）
        Matcher matcher = pattern.matcher(str); // 匹配结果
        while (matcher.find()) { // 匹配结果读找到第一个
            list.add(matcher.group());
        }
        return list.size();
    }
    /**
     * 随机生成5-6位数字
     * @return
     */
    public static int autoNumber(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for(int i = 0; i < 6; i++){
            result = result * 10 + array[i];
        }
        return result;
    }
    /**
     *随机生成6位数字
     */
    public static int autosixNumber(){
        //10000 -5位 1000-4位
        return  (int)((Math.random()*9+1)*100000);
    }
    /**
     * 生成随机数字和字母
     * @param length
     * @return
     */
    public String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    /**
     * 0-9[6位]数字
     * @param postcode
     * @return
     */
    public static boolean checkValidatecode(String postcode) {
        String regex = "[0-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }
    /**
     * 产生指定长度的随机字符串，中文环境下是乱码
     * @param length
     * @return
     */
    public String randomCode(int length){
        return RandomStringUtils.random(length);
    }

    /**
     * 使用指定的字符生成指定长度的随机字符串
     * @param length
     * @return
     */
    public String randomChar(int length){
        return RandomStringUtils.random(length, Constant.BIG_KEY);
    }

    /**
     * 生成指定长度的随机大小写字母组合的字符串
     * @param length
     * @return
     */
    public String randomAlphabetic(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * 生成指定长度的字母数字组合的字符串
     * @param length
     * @return
     */
    public String randomAlphanumeric(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * 生成随机数字字符串
     * @param length
     * @return
     */
    public String randomNumeric(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * 生成从ASCII 32到126组成的随机字符串 （包括符号）
     * @return
     */
    public String randomAscii(int length){
        return RandomStringUtils.randomAscii(length);
    }
}
