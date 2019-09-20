package com.common;

import com.common.entity.UserInfo;
import com.common.tools.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ObjectUtilTests extends ToolsApplicationTests{

	/**
	 * 判断对象是否为空，只要有一个属性为空，则返回true。
	 * 当所有属性不为空时，才返回false。
	 * @throws Exception
	 */
	@Test
	public void checkFieldValueNullTest()  {
		UserInfo userInfo = DataUtils.createData();
		boolean flag = ObjectUtils.checkFieldValueNull(userInfo);
		log.info("得到的结果：{}",flag);
		if(flag){
			log.info("为null");
		}else{
			log.info("不为null");
		}
	}

	/**
	 * 判断对象是否为空，只要有一个属性不为空,就返回false
	 * 只有当对象的所有属性都是null,才返回true
	 */
	@Test
	public void isAllFieldNullTest(){
		UserInfo  userInfo = DataUtils.createData();
		boolean flag = ObjectUtils.checkFieldValueNull(userInfo);
		log.info("得到的结果：{}",flag);
		if(flag){
			log.info("为null");
		}else{
			log.info("不为null");
		}
	}
}
