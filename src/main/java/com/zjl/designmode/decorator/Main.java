package com.zjl.designmode.decorator;

public class Main {
	public static void main(String[] args) {
		Project soft = new SoftwareEmploy();
		Project ma = new ManagerA(soft);
		Project mb = new ManagerB(soft);
		ma.doCoding();
		mb.doCoding();
	}
}
