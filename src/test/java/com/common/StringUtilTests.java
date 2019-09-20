package com.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mockito.internal.util.StringUtil;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StringUtilTests extends ToolsApplicationTests{

	@Test
	public void stringTest(){
		String var1 = "FengHuang";
		String var2 = "Brother";
		String var3 = "fengHuang";
		/*log.info("将第一个目标替换成第二个目标字，返回结果:{}", StringUtil.strReplace(var1,var2));
		log.info("将目标小写变大写，返回结果:{}", StringUtil.toUpperCase(var1,"lower"));
		log.info("比较对应字符的大小，返回结果:{}", StringUtil.toCompareTo(var1,var2));

		log.info("比较时不区分大小写，返回结果:{}", StringUtil.compareToIgnoreCase(var1,var3));*/
	}


}
