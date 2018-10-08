package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年7月23日 下午3:59:48 
*/
public class StreamTest2 {
	public static void main(String[] args) {
		learnStream();
	}

	private static void learnStream() {
		List<Integer> lists = new ArrayList<>();
		lists.add(5);
		lists.add(1);
		lists.add(3);
		lists.add(2);
		lists.add(6);
		lists.add(4);
		lists.add(7);
		System.out.println("lists里面的数据是：");
		for (Integer i : lists) {
			System.out.print(i+" ");
		}
		System.out.println("==========================");
		System.out.println("lists里面的最小值是：");
		Stream<Integer> stream = lists.stream();
		Optional<Integer> min = stream.min(Integer::compareTo);
		if(min.isPresent()){
			System.out.println(min.get());
		}
		System.out.println("=======================");
		System.out.println("lists里面的最大值是：");
		lists.stream().max(Integer::compareTo).ifPresent(System.out::println);
		System.out.println("========================");
		System.out.println("lists进行流排序：");
		lists.stream().sorted().forEach(elem -> System.out.print(elem+" "));
		System.out.println("========================");
		System.out.println("过滤List流,只剩下那些大于3的元素:");
		lists.stream().filter(elem -> elem>3)
					  .forEach(elem -> System.out.print(elem+" "));
		System.out.println("=====================================");
		System.out.println("过滤List流,只剩下那些大于0并且小于4的元素:");
		lists.stream().filter(elem -> elem>0)
					  .filter(elem -> elem<4)
					  .sorted()
					  .forEach(System.out::print);
		System.out.println("========================");
		System.out.println("原List里面的数据:");
		for (Integer i : lists) {
			System.out.print(i+" ");
		}
	}
}

