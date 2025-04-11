package leetcode.dailyquetion;

import java.util.HashSet;
import java.util.Set;

public class MinOperations {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr= {5,2,5,4,5};
//			{2,1,2};

		int k= 2;
		
		System.out.println("total distinct: "+solution.minOperations(arr, k));
	}
}

class Solution {
	public int minOperations(int[] nums, int k) {

		Set<Integer> numSet = new HashSet<Integer>();

		for (int i : nums) {
			numSet.add(i);
		}

		Set<Integer> diffSet = new HashSet<Integer>();

		for (int num : numSet) {
			if (num > k) {
				System.out.println(num);

				int diff = num - k;
				System.out.println(numSet.contains(diff));
				if (numSet.contains(diff)) {
					diffSet.add(diff);
				}
			} else if (num < k) {
				return -1;
			}
		}
		
		for (int num : nums) {
            if (num > k) {
                int diff = num - k;
                if (numSet.contains(diff)) {
                    diffSet.add(diff);
                } else if(num == k) {
                    continue;
                }
            } else if (num < k) {
                return -1; 
            }
        }
		System.out.println(numSet);

		return diffSet.size();
	}
}