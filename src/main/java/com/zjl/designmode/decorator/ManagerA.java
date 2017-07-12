package com.zjl.designmode.decorator;

public class ManagerA extends Manager {

	public ManagerA(Project project) {
		super(project);
	}
	public void doEarlyWork() {
		System.out.println("经理A做前期架构！！！");
	}
}
