package java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreationStream {

	public static void main(String[] args) {

		List<String> name = List.of("Jenil","Nikhil","Ankit");
		Stream<String> stream1 = name.stream();
		Stream<Integer> stream2 = Arrays.stream(new Integer[] {1,2,3}); 
		Stream<String> stream3 = Stream.of("Java","Python");
		
		//Infinite Stream (use carefully)
		Stream<Double> stream4 = Stream.generate(Math::random).limit(5);

		
		// From a Collection
		stream1.forEach((n) ->System.out.println(n));
		
		// From an array
		stream2.forEach((n) ->System.out.println(n));
		
		// From values
		stream3.forEach((n) ->System.out.println(n));
		
		stream4.forEach((n) ->System.out.println(n));


	}
	
}
