package com.zjl.thread;

public class SyncCodeBlock {
	public int i;
	public void syncTask(){
		synchronized (this) {
			i++;
		}
	}
}
