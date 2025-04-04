package collectionEclipse.queue.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {

	public static void main(String[] args) {
		
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
		
		for(int i=1; i<=5; i++) {
			abq.add(i);
		}
		abq.add(5);
		abq.add(5);
	

		try {
			abq.put(10);
		} catch (InterruptedException e) {
			System.out.println("it is full");
		}
		
		
		//if it is full it give false else true
		System.out.println(abq.offer(11));
		abq.forEach(System.out::println);
		
		System.out.println(abq.poll());
		try {
			System.out.println(abq.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
