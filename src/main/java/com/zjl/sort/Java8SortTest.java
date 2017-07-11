package com.zjl.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java8SortTest {
	public static void main(String[] args) {
		Employee e1 = new Employee(10, "aname", "dname", 25);
		Employee e2 = new Employee(2, "nname", "uname", 22);
		Employee e3 = new Employee(3, "nname", "sname", 33);
		Employee e4 = new Employee(4, "dname", "zname", 23);
		List<Employee> es = new ArrayList<>();
		es.add(e1);
		es.add(e2);
		es.add(e3);
		es.add(e4);
		System.out.println(es);
		System.out.println("=========================");
		es.sort(Comparator.comparing(Employee :: getFirstName).thenComparing(Employee :: getLastName));
		System.out.println(es);
	}
}
