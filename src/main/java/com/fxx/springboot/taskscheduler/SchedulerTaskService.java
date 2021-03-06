package com.fxx.springboot.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:33:12 
*/
@Service
public class SchedulerTaskService {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	@Scheduled(fixedRate=5000)
	public void reportCurrentTime(){
		System.out.println("每隔5秒执行一次："+sdf.format(new Date()));
	}
	@Scheduled(cron="0 40 14 ? * *")
	public void fixTime(){
		System.out.println("指定时间执行："+sdf.format(new Date()));
	}
}

