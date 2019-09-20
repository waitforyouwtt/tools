package com.common;

import com.common.enums.DateFormatEnum;
import com.common.tools.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class DateUtilTests extends ToolsApplicationTests{

	@Test
	public void dateTest() throws Exception {
		log.info("获取当天日期LocalDate：{}", DateUtils.getNow());
		log.info("获取当天日期String：{}", DateUtils.curYearMonthDay());
		LocalDate d1 = LocalDate.of(2019,6,29);
		LocalDate d2 = LocalDate.of(2018,6,29);
		log.info("判断日期是否相等LocalDate：{}", DateUtils.equalsLocalDate(d1,d2));
		log.info("获取当前时间LocalTime：{}", DateUtils.getTime());
		log.info("在现有的时间上增加?时间LocalTime：{}", DateUtils.nowPlusTime(1,6));
		log.info(" 计算**[? ,年/月/周/日]后的日期LocalDate：{}", DateUtils.nowPlusDate(1,1));
		log.info(" 计算**[? ,年/月/周/日]前的日期LocalDate：{}", DateUtils.nowMinusDate(4,1));
		log.info(" 使用Java 8的Clock时钟类：{}", DateUtils.systemUTC());
		log.info("判断日期是早于还是晚于另一个日期LocalDate：{}", DateUtils.isBefore(d2,d1));
		LocalDateTime d3 = LocalDateTime.of(2019,12,12, 12,12,12);
		log.info("diyDate LocalDateTime：{}", DateUtils.diyDate(d3,3));
		Date d4 = new Date();
		String d5 = "2019-06-29";
		String d6 = "2019-07-10 12:12:12";
		log.info("diyDate Date：{}", DateUtils.diyDate(d4,3));
		log.info("获取指定日期所在周的第一天和最后一天,用下划线连接 String：{}", DateUtils.getFirstAndLastOfMonth(d5));
		log.info("按照指定格式解析时间 String：{}", DateUtils.parseTime(d6));
		log.info("字符串转instant 带时分秒{}",DateUtils.strToInstant(d6));
		log.info("字符串转LocalDateTime {}",DateUtils.strToLocalDateTime(d6));
		log.info("获取时间 format 格式 {}",DateUtils.getDateFormat(d4,"yyyy-mm-dd HH:mm:ss"));
		log.info("获取时间 format 格式 {}",DateUtils.getDateFormat(d6,"yyyy-mm-dd HH:mm:ss"));
		log.info("获取时间 的下N个月日期 {}",DateUtils.getNextMon(1));
		log.info("获取前days日 {}",DateUtils.getDateForDayBefor(1, DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getMsg()));
		log.info("时间相加 {}",DateUtils.addDateTime(d4, 1,2));
		log.info("根据字符串和指定格式生成日期 {}",DateUtils.getDate(d6, DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getMsg()));
		log.info("计算两个日期之间相差的天数 {}",DateUtils.daysBetween(d4,d4));
		log.info("判断当前日期是星期几 {}",DateUtils.dayForWeek(d4));
		log.info("根据身份证号取得年龄 {}",DateUtils.calculateAge("411421199308236039","yyyy-MM-dd"));
		log.info("string 转date 格式 {}",DateUtils.strToDateLong(d6));
	}

	@Test
	public void getLog(){
		LocalDateTime d3 = LocalDateTime.of(2019,12,12, 12,12,12);
		log.info("diyDate LocalDateTime：{}", DateUtils.diyDate(d3,4));
	}

}
