package leetcode.arrays.firstMissingPositive;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMissingPositive {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {0,2,1};
		System.out.println("missing :"+solution.firstMissingPositive(arr));
	}
	
	
}

//1,2,0

class Solution{
	public int firstMissingPositive(int[] nums) {

		List<Integer> list = new LinkedList<>();
		for (Integer i : nums) {
			list.add(i);
		}

		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());

		int missing = 0;
		System.out.println(sorted);
		if (sorted.contains(1)) {
			for (int i = 1; i < sorted.size(); i++) {

				if(sorted.get(i)>0) {
					System.out.println("i: "+sorted.get(i));
					System.out.println("i-1 :"+(sorted.get(i)-1));
					if (sorted.get(i) - 1 != sorted.get(i)) {
						System.out.println(sorted.get(i) + 1);
						return missing = sorted.get(i) + 1;
					} else if (i == sorted.size() && missing == 0) {
						return missing = sorted.get(i) + 1;
					}
				}
				
			}

		} else {
			return 1;
		}

		return missing;

	}
}