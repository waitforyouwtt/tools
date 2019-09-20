package com.common;

import com.common.tools.OperationListUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OperationListUtilTests extends ToolsApplicationTests{

	@Test
	public void contextLoads() {
		List<String> mList = new ArrayList<>();
		mList.add("s1");
		mList.add("s2");
		mList.add("s3");
		// // method1: In Java 8 ~ String.join(..)
		// String mListStr = String.join(",", mList);
		// String mListStr = listToString(mList);
		String str = OperationListUtils.listToString(mList);
		log.info("str = " + str);
	}

}
