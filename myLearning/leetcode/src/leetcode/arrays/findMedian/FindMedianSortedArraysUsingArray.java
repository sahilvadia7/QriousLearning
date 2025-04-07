package leetcode.arrays.findMedian;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMedianSortedArraysUsingArray {

	public static void main(String[] args) {
		int[] arr1 = {1,3};
		int[] arr2 = {2};
		System.out.println(findMedianSortedArrays(arr1,arr2));
	}

	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
		 int[] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
		 
		 int n =arr.length;
	        
	        if(n %2!=0) {
	            return arr[n / 2];
	        	
	        }else {
	            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;

	        }
	        
	        
	    }

}
