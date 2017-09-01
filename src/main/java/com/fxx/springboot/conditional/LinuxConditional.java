package com.fxx.springboot.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:45:03 
*/
public class LinuxConditional implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata arg1) {
		return context.getEnvironment().getProperty("os.name").contains("Linux");
	}
	

}

