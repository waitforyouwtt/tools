package com.common;

import com.common.entity.UserInfo;
import com.common.entity.UserInfoCopy;
import com.common.tools.CGlibMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CGlibMapperTests extends ToolsApplicationTests{

	@Test
	public void contextLoads() {
		UserInfo user = DataUtils.createData();
		UserInfoCopy copy = new UserInfoCopy();
		CGlibMapper.mapperObject(user,copy);
		log.info("得到的结果：{}",copy.toString());
	}

}
