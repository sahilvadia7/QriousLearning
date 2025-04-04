package collectionEclipse.queue.arraydeque;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
	public static void main(String[] args) {
		
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		ad.add(1);
		ad.add(2);
		ad.add(5);
		ad.add(4);
		ad.add(3);

		
		ad.forEach(System.out::println);
		
		System.out.println("Poll");
		while(!ad.isEmpty()) {
			System.out.println(ad.poll());
		}
	}
}
