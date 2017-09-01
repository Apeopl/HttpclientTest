package com.fxx.springboot.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.fxx.springboot.anno.Action;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 上午10:11:34 
*/
@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.fxx.springboot.anno.Action)")
	public void annotationPointCut(){
		
	}
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截："+action.name());
	}
	@Before("execution(* com.fxx.springboot.service.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截："+method.getName());
	}
}

