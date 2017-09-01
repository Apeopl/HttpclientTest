package com.fxx.springboot.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午3:26:20 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanTest {
	@Autowired
	private TestBean testBean;
	
	@Test
	public void test(){
		String expect = "develop";
		String content = testBean.getContent();
		//Assert.assertEquals(expect, content);
		System.out.println(content);
	}
}

