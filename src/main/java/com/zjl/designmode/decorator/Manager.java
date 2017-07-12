package com.zjl.designmode.decorator;

public class Manager implements Project {
	private Project project;
	public Manager(Project project){
		this.project = project;
	}
	@Override
	public void doCoding() {
		startCoding();
	}

	public void startCoding() {
		doEarlyWork();
		project.doCoding();
		doEndWork();
	}
	public void doEarlyWork() {
		
	}
	public void doEndWork() {
		
	}

}
