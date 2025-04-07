package java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class Reduce {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int result = numbers
		  .stream()
		  .reduce(0, Integer::sum);
		System.out.println(result);
	}
}
