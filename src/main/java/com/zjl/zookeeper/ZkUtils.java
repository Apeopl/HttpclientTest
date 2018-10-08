package com.zjl.zookeeper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 描述：
 * 
 * @author zhengjinlei
 * @version 2018年9月20日 下午2:16:22
 */
public class ZkUtils {
	/**
	 * 对子节点排序
	 *
	 * @param node
	 */
	public static void childNodeSort(List<String> node) {
		Collections.sort(node, new ChildNodeCompare());
	}

	private static class ChildNodeCompare implements Comparator<String> {
		public int compare(String childNode1, String childNode2) {
			return childNode1.compareTo(childNode2);
		}
	}
}
