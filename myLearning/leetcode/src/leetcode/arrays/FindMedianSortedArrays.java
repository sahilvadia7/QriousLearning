package leetcode.arrays;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindMedianSortedArrays {
	
	public static void main(String[] args) {
		int[] arr1 = {1,3};
		int[] arr2 = {2};
		System.out.println(findMedianSortedArrays(arr1,arr2));
//		findMedianSortedArrays(arr1,arr2);
	}

	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 PriorityQueue<Integer> ad = new PriorityQueue<>();
		 LinkedList<Integer> ll = new LinkedList<>();
		 int length =nums1.length+nums2.length;
		 double median =0 ;

	        for(int i = 0; i<length; i++){
	            if(i<nums1.length){
	                ad.add(nums1[i]);
	            }else{
	                ad.add(nums2[i-nums1.length]);
	            }
	        }
	        
	        System.out.print(ad+",");
	        while(!ad.isEmpty()) {
				ll.add(ad.poll());
			}
	        
	        System.out.print(ll+",");

	        
	        if(ll.size() %2!=0) {
	        	median= ll.get(ll.size()/2);
	        	
	        }else {
	        	median = (ll.get(ll.size()/2-1)+ ll.get(ll.size()/2))/2d;
//	        	System.out.println((ll.get(ll.size()/2-1)+ ll.get(ll.size()/2)));
//	        	System.out.println(ll.get(length/2-1));
//	        	System.out.println(ll.get(length/2));

	        }
	        
//	 	       System.out.println(median);

	        
	       return median;
	        
	        
	    }
}

//Stream<Integer> numA1=null;
//Stream<Integer> numA2=null;
//
//for(int i=0; i<nums1.length; i++) {
//    numA1 = Stream.of(nums1[i]); 
//}
//
//for(int i=0; i<nums2.length; i++) {
//   numA2 = Stream.of(nums2[i]); 
//
//}
//
//Stream<Integer> fArr = Stream.concat(numA1, numA2).sorted();
//fArr.forEach((n) -> System.out.println(n));
//
