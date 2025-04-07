package java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fillter {

	public static void main(String[] agrs) {
		List<String> names = List.of("Axsy","Nikhil","Aryan","Ankit","Jenil","Nikhil","Ankit")
				.stream()		
			    .filter(name -> name.startsWith("A"))
			    .map(String::toUpperCase)
			    .distinct()
			    .sorted()
//			    .peek(System.out::print)
				.collect(Collectors.toList());
		
//		names.forEach(System.out::println);
		List<Integer> numbers = List.of(1,4,6,7,5,4,7,35,54,234,5,6,57,5,74,3,46,57,547,145);
		
		Long i = numbers.stream()
			.filter(n->n%2==0)
			.map(n->n+n)
			.distinct()
			.count();
		
		System.out.println("Count: "+i);
//			.forEach(System.out::println);
		
		int[] arr1 = {1,3,5,11,7,9};
		int[] arr2 = {2,4,6,8,10};
		
		List<List<Integer>> innerList = List.of(List.of(1,3,5,7,9,11),List.of(2,4,6,8,10));
		
		 List<Integer> marged = innerList.stream()
			.flatMap(List::stream)
			.sorted()
//			.peek(System.out::print)
			.collect(Collectors.toList());
		 
		 marged.forEach(System.out::print);
		
		 
		 System.out.println();
		List<List<Integer>> nestedList = List.of(
				IntStream.of(arr1).boxed().collect(Collectors.toList()),
				IntStream.of(arr2).boxed().collect(Collectors.toList())
				);
				
		
		int sum = nestedList.stream()
			.flatMap(List::stream)
			.sorted()
			.reduce(0,Integer::max);
		
		System.out.println(sum);
//			.forEach(System.out::print);
	}
}
