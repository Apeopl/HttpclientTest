package com.zjl.zookeeper;
/** 
* 描述：
* @author zhengjinlei 
* @version 2018年9月20日 下午2:01:01 
*/

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ReentrantZKLock {
	private final static String BASE_NODE = "/baseNode";
	private final static String CHILDREN_NODE = "/node_";
	private final Lock localLock;
	private final Condition condition;
	
	private static ThreadLocal<AtomicInteger> threadLocal = new ThreadLocal<>();
	private ZooKeeper zooKeeper = null;
	private String node = null;
	public ReentrantZKLock(String addr,int timeout){
		try {
			zooKeeper = new ZooKeeper(addr, timeout, new SessionWatcher());
			localLock = new ReentrantLock();
			condition = localLock.newCondition();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void lock() {
		//重入检测
		if (checkReentrant()) {
			return;
		}
		try {
			node = zooKeeper.create(BASE_NODE + CHILDREN_NODE, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			while (true) {
				localLock.lock();
				try {
					List<String> childrenNodes = zooKeeper.getChildren(BASE_NODE, false);
					ZkUtils.childNodeSort(childrenNodes);
					//当前节点的索引
					int myNodeIndex = childrenNodes.indexOf(node);
					//当前节点的前一个节点
					int beforeNodeIndex = myNodeIndex - 1;
					Stat stat = null;
					while (beforeNodeIndex >= 0) {
						stat = zooKeeper.exists(childrenNodes.get(beforeNodeIndex), new PredecessorNodeWatcher(condition));
						if (stat != null) {
							break;
						}
					}
					if (stat != null) { //前序节点存在，等待前序节点被删除，释放锁
						condition.await();
					} else { // 获取到锁
						threadLocal.set(new AtomicInteger(1));
						return;
					}
				} finally {
					localLock.unlock();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void unlock() {
		AtomicInteger times = threadLocal.get();
		if (times == null) {
			return;
		}
		if (times.decrementAndGet() == 0) {
			threadLocal.remove();
			try {
				zooKeeper.delete(node, -1);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	private boolean checkReentrant() {
		AtomicInteger times = threadLocal.get();
		if (times != null) {
			times.incrementAndGet();
			return true;
		}
		return false;
	}
}

