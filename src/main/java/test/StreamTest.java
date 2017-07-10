package test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
		List<Integer> list = IntStream.range(0, 20).boxed().collect(Collectors.toList());
		String string = list.stream().filter(n -> n%2==0)
		.sorted(Comparator.comparing((Integer i)->i).reversed())
		.limit(4)
		.peek((i)->System.out.println("remained："+i))
		.map(String::valueOf)
		.collect(Collectors.joining(",","a","b"));
		System.out.println(string);
	}
}
