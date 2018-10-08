package com.zjl.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 描述：
 * 
 * @author zhengjinlei
 * @version 2018年9月20日 下午2:18:15
 */
public class SessionWatcher implements Watcher {

	public void process(WatchedEvent event) {
		if (event.getState() == Event.KeeperState.SyncConnected) {
		}
	}

}
