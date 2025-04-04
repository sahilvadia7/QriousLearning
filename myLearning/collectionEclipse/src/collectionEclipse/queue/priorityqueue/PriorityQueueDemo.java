package collectionEclipse.queue.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
	
		PriorityQueue<String> pq = new PriorityQueue<String>();
		PriorityQueue<Integer> num = new PriorityQueue<Integer>();
		
		ArrayList<Integer> sortedNum = new ArrayList<>();
		pq.add("ankit");
		pq.add("nikhil");
		pq.add("Aryan");
		pq.offer("nikhil");
		pq.add("Jenil");
		
		
		num.add(92);
		num.add(10);
		num.add(65);
		num.add(110);
		num.add(24);
		num.add(12);
		num.add(1);
//		
		num.peek();
		

		
//		System.out.println("Loop");
		for(int i=30; i>0; i--) {
			num.add(i);
		}

		while(!num.isEmpty()) {
//			System.out.println(num.poll());
			sortedNum.add(num.poll());

		}

		sortedNum.forEach(System.out::println);
//		num.forEach(System.out::println);
	}
}
