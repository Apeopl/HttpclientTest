package com.fxx.springboot.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:27:23 
*/
public class AsyncTaskMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService taskService = context.getBean(AsyncTaskService.class);
		for(int i=0; i<10; i++){
			taskService.executeAsyncTask(i);
			taskService.executeAsyncTaskPlus(i);
		}
		context.close();
	}
}

