package collectionEclipse.set.treeset;

import java.util.TreeSet;

public class TreesetDemo {

	public static void main(String[] args) {
		
		TreeSet<String> treeset = new TreeSet<String>();
		
		treeset.add("Orange");
		treeset.add("Mango");
		treeset.add("Banana");
		treeset.add("Kiwi");
//		treeset.add(null); not allowed
//		treeset.add(null);
		
		treeset.forEach(System.out::println);
		
		
		System.out.println("---- Method ---");
		System.out.println("First Element :"+treeset.first());
		System.out.println("isEmpty :"+treeset.isEmpty());
		System.out.println("last Element :"+treeset.last());
		System.out.println("lower {Kiwi} Element :"+treeset.lower("Kiwi"));
		System.out.println("PollFirst Element :"+treeset.pollFirst());
		System.out.println("PollLast Element :"+treeset.pollLast());
		
	}
}
