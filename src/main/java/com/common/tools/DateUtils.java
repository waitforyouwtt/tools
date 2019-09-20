package com.common.tools;

import com.common.enums.DateFormatEnum;
import com.common.enums.TimeEnum;
import lombok.extern.slf4j.Slf4j;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.time.ZoneOffset.ofHours;
import static java.time.temporal.ChronoUnit.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:32
 * @Email: 15290810931@163.com
 */
@Slf4j
public class DateUtils {


    /**
     * 获得当天的日期
     * @return [2018-11-19]
     */
    public static LocalDate getNow(){
        return LocalDate.now();
    }
    /**
     * 获取当前日期的年月日
     * @return [2018-11-19]
     */
    public static String curYearMonthDay(){
        LocalDate date = LocalDate.now();
        return date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth()+"";
    }
    /**
     * 比较两个日期是否相等
     * @return [true/false]
     */
    public static boolean equalsLocalDate(LocalDate var1,LocalDate var2){
        if (var1 == null || var2 == null){
            throw new IllegalArgumentException("Parameter can not be empty");
        }
        return var1.equals(var2);
    }
    /**
     * 获取当前时间
     * @return [18:23:09.768]
     */
    public static LocalTime getTime(){
        return  LocalTime.now();
    }
    /**
     * 在现有的时间上增加?时间
     * 1,2,3
     */
    public static LocalTime nowPlusTime(int timeType,int number){
        LocalTime localTime;
        if (timeType == TimeEnum.HOUR.getCode()){
            localTime =  LocalTime.now().plusHours(number);
        }else if(timeType == TimeEnum.MINUTE.getCode()){
            localTime = LocalTime.now().plusMinutes(number);
        }else if(timeType == TimeEnum.SECOND.getCode()){
            localTime = LocalTime.now().plusSeconds(number);
        }else{
            throw new IllegalArgumentException("parameter error");
        }
        return localTime;
    }
    /**
     *  计算**[? ,年/月/周/日]后的日期
     */
    public static LocalDate nowPlusDate(int dateType,int number){
        LocalDate localDate;
        switch (dateType){
            case 1:
                localDate = LocalDate.now().plus(number,YEARS);
                break;
            case 2:
                localDate = LocalDate.now().plus(number,MONTHS);
                break;
            case 3:
                localDate = LocalDate.now().plus(number,WEEKS);
                break;
            case 4:
                localDate = LocalDate.now().plus(number,DAYS);
                break;
            default:
                throw new IllegalArgumentException("Parameter error");
        }
        return localDate;
    }
    /**
     *  计算**[? ,年/月/周/日]前的日期
     */
    public static LocalDate nowMinusDate(int dateType,int number){
        LocalDate localDate;
        switch (dateType){
            case 1:
                localDate = LocalDate.now().minus(number,YEARS);
                break;
            case 2:
                localDate = LocalDate.now().minus(number,MONTHS);
                break;
            case 3:
                localDate = LocalDate.now().minus(number,WEEKS);
                break;
            case 4:
                localDate = LocalDate.now().minus(number,DAYS);
                break;
            default:
                throw new IllegalArgumentException("Parameter error");
        }
        return localDate;
    }

    /**
     * 使用Java 8的Clock时钟类
     */
    public static Clock systemUTC(){
        return Clock.systemUTC();
    }
    /**
     * 判断日期是早于还是晚于另一个日期
     */
    public static boolean isBefore(LocalDate var1,LocalDate var2){
        return !var1.isAfter(var2);
    }

    /**
     * diy 日期
     */
    public static String diyDate(LocalDateTime date,int intFormat) throws DateTimeParseException {
        DateTimeFormatter format;
        if (intFormat == DateFormatEnum.BLANK_FORMAT.getCode()){
            format =  DateTimeFormatter.ofPattern(DateFormatEnum.BLANK_FORMAT.getMsg());
        }else if (intFormat == DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getCode()){
            format =  DateTimeFormatter.ofPattern(DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getMsg());
        }else if (intFormat == DateFormatEnum.YY_MM_DD_HH_MM_SS.getCode()){
            format =  DateTimeFormatter.ofPattern(DateFormatEnum.YY_MM_DD_HH_MM_SS.getMsg());
        }else if(intFormat == DateFormatEnum.YY_MM_DD_HH_MM_SS2.getCode()){
            format =  DateTimeFormatter.ofPattern(DateFormatEnum.YY_MM_DD_HH_MM_SS2.getMsg());
        }else{
            throw new IllegalArgumentException("Parameter error");
        }
        return date.format(format);
    }

    /**
     * diy 日期
     */
    public static String diyDate(Date date,int intFormat) {
        SimpleDateFormat format;
        if(intFormat == DateFormatEnum.BLANK_FORMAT.getCode()){
            format = new SimpleDateFormat(DateFormatEnum.BLANK_FORMAT.getMsg());
        }else if (intFormat == DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getCode()){
            format = new SimpleDateFormat(DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getMsg());
        }else if (intFormat == DateFormatEnum.YY_MM_DD_HH_MM_SS.getCode()){
            format = new SimpleDateFormat(DateFormatEnum.YY_MM_DD_HH_MM_SS.getMsg());
        }else{
            throw new IllegalArgumentException("Parameter error");
        }
        return format.format(date);
    }
    /**
     * 获取指定日期所在周的第一天和最后一天,用下划线连接
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getFirstAndLastOfMonth(String date){
        LocalDate inputDate = LocalDate.parse(date);
        TemporalAdjuster first_of_week = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue()- DayOfWeek.MONDAY.getValue()));
        TemporalAdjuster last_of_week = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        return inputDate.with(first_of_week)+"_"+ inputDate.with(last_of_week);
    }
    /**
     * 按照"yyyy-MM-dd HH:mm:ss" 解析时间
     */
    public static Date parseTime(String date) {
        LocalDateTime localDateTime = parseDateTime(date, DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getMsg());
        return fromLocalDateTime(localDateTime);
    }
    public static Date fromLocalDateTime(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * 按照指定格式指定时间
     */
    private static LocalDateTime parseDateTime(String dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * 字符串转instant 带时分秒
     * @param date
     * @return
     */
    public static Instant strToInstant(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getMsg());
        LocalDateTime localDateTime = LocalDateTime.parse(date, df);
        Instant ins= localDateTime.toInstant(ofHours(8)).plus(Duration.ofHours(8L));
        return ins;
    }

    /**
     * 字符串转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime strToLocalDateTime(String date){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, df);
    }
    /**
     * 获取时间 format 格式
     * @return time
     */
    public static String getDateFormat(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return  df.format(date);
    }

    /**
     * 获取当前时间 format 格式
     */
    public static String getDateFormat(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * 获取某时间-当前时间 format 格式
     * @throws ParseException
     */
    public static int getDateFormat(String endDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long days = 0;
        try {
            Date eDate = sdf.parse(endDate);
            Date date = sdf.parse(getDateFormat(format));

            long diff = eDate.getTime() - date.getTime();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (Exception e) {

        }
        return (int) days;
    }

    /**
     * 获取某时间-某时间 format 格式
     * @throws ParseException
     */
    public static String getDateFormat(String endDate0, String endDate1, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long days = 0;
        try {
            Date eDate0 = sdf.parse(endDate0);
            Date eDate1 = sdf.parse(endDate1);
            long diff = eDate1.getTime() - eDate0.getTime();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (Exception e) {

        }
        return String.valueOf(days);
    }

    /**
     * 获取下n月
     */
    public static Date getNextMon(int month) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, +month);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取前days日
     */
    public static String getDateForDayBefor(int days, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(calendar.getTime());
    }

    /**
     * 时间相加
     *
     * @param date
     * @param number 日 时 分 月 年
     * @return date
     */
    public static Date addDateTime(Date date,int number,int type){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        Date result ;
        switch (type){
            case 1:
                calendar.add(Calendar.YEAR, number);
                result = calendar.getTime();
                break;
            case 2:
                calendar.add(Calendar.MONTH, number);
                result = calendar.getTime();
                break;
            case 3:
                calendar.add(Calendar.DAY_OF_MONTH, number);
                result = calendar.getTime();
                break;
            case 4:
                calendar.add(Calendar.HOUR, number);
                result = calendar.getTime();
                break;
            case 5:
                calendar.add(Calendar.MINUTE, number);
                result = calendar.getTime();
                break;
            default:
                throw new IllegalArgumentException("Parameter error");
        }
        return result ;
    }


    /**
     * 根据字符串和指定格式生成日期
     *
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            log.error("getDate error: dateString{}, format{}", dateString, format, e);
        }
        return date;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 后者大则true
     *
     * @param smdate  较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static boolean compareDate(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1);
        return between_days > 0 ? true : false;
    }

    public static String fyTimePattern = "yyyyMMdd";

    /**
     *
     * return yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String fyFormatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(fyTimePattern);
        String sDate = f.format(date);
        return sDate;
    }

    public static boolean isEarlyMorning(Date date) {
        return isIn("00:00:00", "07:00:00", date);
    }

    public static boolean isMorning(Date date) {
        return isIn("07:00:00", "11:00:00", date);
    }

    public static boolean isNoon(Date date) {
        return isIn("11:00:00", "14:00:00", date);
    }

    public static boolean isAfternoon(Date date) {
        return isIn("14:00:00", "19:00:00", date);
    }

    public static boolean isNight(Date date) {
        return isIn("19:00:00", "24:00:00", date);
    }

    private static boolean isIn(String start, String end, Date target) {
        if(target == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            start = sdf.format(target) + " " + start;
            end = sdf.format(target) + " " + end;
            long s = sdf1.parse(start).getTime();
            long e = sdf1.parse(end).getTime();
            if(target.getTime() >= s && target.getTime() < e) {
                return true;
            }
        } catch (Exception e) {
            log.error("isIn error", e);
        }
        return false;
    }

    /**
     * 判断当前日期是星期几
     *
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int dayForWeek(Date date) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    public static boolean isWeekDay(Date date) {
        if(date == null)
            return false;
        try {
            int day = dayForWeek(date);
            // 周日是1，周六是7
            if(day >= 2 && day <= 6) {
                return true;
            }
        } catch (Exception e) {
            log.error("isWeekDay error", e);
        }
        return false;
    }

    /**
     * 根据身份证号取得年龄
     *
     * @param idcard
     * @param format
     * @return
     */
    public static int calculateAge(String idcard, String format) {
        int age = 0;
        try {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat(format);
            // 当前年份
            String fyear = df.format(date).substring(0, 4);
            // 当前月份
            String fmonth = df.format(date).substring(5, 7);
            //根据身份证号得到年份 ,月份
            String year = idcard.substring(6,10);
            String month = idcard.substring(10,12);
            // 当前月份大于用户出身的月份表示已过生
            if (Integer.parseInt(month) <= Integer.parseInt(fmonth)) {
                age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;
            } else {
                // 当前用户还没过生
                age = Integer.parseInt(fyear) - Integer.parseInt(year);
            }
        } catch (Exception e) {
            log.error("calculateAge error", e);
        }
        return age;
    }

    /**
     * string 转date
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.parse(strDate, new ParsePosition(0));
    }

}
