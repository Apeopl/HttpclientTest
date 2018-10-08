package com.zjl.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年9月21日 上午10:58:45 
*/
public class CuratorTest {
	public static void main(String[] args) throws Exception {
		//创建zookeeper客户端
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
		client.start();
		//创建分布式锁
		InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
		mutex.acquire();
		//业务流程
		mutex.release();
		client.close();
	}
}

