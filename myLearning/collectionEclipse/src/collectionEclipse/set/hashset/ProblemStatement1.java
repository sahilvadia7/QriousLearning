package collectionEclipse.set.hashset;

import java.util.HashSet;

public class ProblemStatement1 {
	
	public static void main(String[] args) {
		HashSet<String> names = new HashSet<>();
		
		names.add("Alice");
		names.add("Eve");
		names.add("Jenil");
		names.add("Jenil");		
		names.add("Nikhil");
		names.add("Ankit");
		
		names.forEach(System.out::println);
	}

}
