package com.zjl.designmode.decorator;

public class ManagerB extends Manager {

	public ManagerB(Project project) {
		super(project);
	}
	public void doEarlyWork() {
		System.out.println("经理B做需求分析！！！");
	}
	public void doEndWork() {
		System.out.println("经理B做后期工作！！！");
	}
}
