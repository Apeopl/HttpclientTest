package com.zjl.zookeeper;

import java.util.concurrent.locks.Condition;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 描述：
 * 
 * @author zhengjinlei
 * @version 2018年9月20日 下午2:17:41
 */
public class PredecessorNodeWatcher implements Watcher {

	private Condition condition = null;

	public PredecessorNodeWatcher(Condition condition) {
		this.condition = condition;
	}

	public void process(WatchedEvent event) {
		// 前序节点被删除，锁被释放，唤醒当前等待线程
		if (event.getType() == Event.EventType.NodeDeleted) {
			condition.signal();
		}
	}

}
