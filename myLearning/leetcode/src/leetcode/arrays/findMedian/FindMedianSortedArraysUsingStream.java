package leetcode.arrays.findMedian;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMedianSortedArraysUsingStream {
	public static void main(String[] args) {
		int[] arr1 = {1,3};
		int[] arr2 = {2};
		System.out.println(findMedianSortedArrays(arr1,arr2));
	}

	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {		 
		 List<List<Integer>> list = List.of(
				 IntStream.of(nums1).boxed().collect(Collectors.toList()),
				 IntStream.of(nums2).boxed().collect(Collectors.toList())
				 );
				 
		List<Integer> Rlist = 
			list.stream()
			.flatMap(List::stream)
		 	.sorted()
		 	.collect(Collectors.toList());
				 
				 
		 int length =Rlist.size();
		 double median =0 ;

	        
		 
		 System.out.println(Rlist);
	        if(length %2!=0) {
	        	median= Rlist.get(length/2);
	        	
	        }else {
	        	median = (Rlist.get(length/2-1)+ Rlist.get(length/2))/2d;

	        }
	        
	       return median;
	        
	    }
}
