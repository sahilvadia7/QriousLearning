package collectionEclipse.set.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		
		
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("Alice");
		lhs.add("Eve");
		lhs.add("Jenil");
		lhs.add("Jenil");		
		lhs.add("Nikhil");
		lhs.add("Ankit");
		lhs.add(null);
		lhs.add(null);
		lhs.add(null);
		
		lhs.forEach(System.out::println);
			
	}
}
