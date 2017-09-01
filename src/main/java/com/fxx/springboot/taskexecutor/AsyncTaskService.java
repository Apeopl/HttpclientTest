package com.fxx.springboot.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:24:41 
*/
@Service
public class AsyncTaskService {
	@Async
	public void executeAsyncTask(Integer i){
		System.out.println("执行异步任务："+i);
	}
	@Async
	public void executeAsyncTaskPlus(Integer i){
		System.out.println("执行异步任务+1："+(i+1));
	}
}

