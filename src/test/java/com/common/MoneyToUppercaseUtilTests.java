package com.common;

import com.common.tools.MoneyToUppercaseUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class MoneyToUppercaseUtilTests extends ToolsApplicationTests{

	@Test
	public void test() {
		double money = -1000001.672;
		BigDecimal numberOfMoney = new BigDecimal(money);
		String s = MoneyToUppercaseUtils.number2CNMontrayUnit(numberOfMoney);
		System.out.println("你输入的金额为：【"+ money +"】   #--# [" +s.toString()+"]");
	}

}
