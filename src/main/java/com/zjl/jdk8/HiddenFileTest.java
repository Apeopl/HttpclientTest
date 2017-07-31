package com.zjl.jdk8;

import java.io.File;
import java.io.FileFilter;

/** 
* 描述：隐藏的文件
* @author zhengjinlei 
* @version 2017年7月31日 上午10:14:57 
*/
public class HiddenFileTest {
	public static void main(String[] args) {
		File[] hiddenFile = new File("D:\\ZZZ\\资料\\资料").listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isHidden();
			}
		});
		for (File file : hiddenFile) {
			System.out.println(file.getName());
		}
	}
}

