package leetcode.arrays.firstMissingPositive;



import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {100000, 3, 4000, 2, 15, 1, 99999};
		System.out.println("missing :"+solution.firstMissingPositive(arr));
	}
	
	
}

//1,2,0

class Solution{
	
	public int firstMissingPositive(int[] nums) {
	    Set<Integer> set = new HashSet<>();
	    for (int num : nums) {
	        if (num > 0) {
	            set.add(num);
	        }
	    }

	    for (int i = 1; i <= nums.length + 1; i++) {
	        if (!set.contains(i)) {
	            return i;
	        }
	    }

	    return -1;
	}

	
}
	

//incorrect login
	
//	public int firstMissingPositive(int[] nums) {
//
//		Arrays.sort(nums);
//		int k = 0;
//
//		List<Integer> list = new LinkedList<>();
//		for (Integer i : nums) {
//			list.add(i);
//		}
//
//		System.out.println(list);
//		if (list.size() == 1) {
//			if (list.get(0) == 0) {
//				return 1;
//			} else if (list.get(0) == 1) {
//				return list.get(0) + 1;
//			} else {
//				return 1;
//			}
//		} else {
//
//			for (int i = 1; i < nums.length; i++) {
//			
//				if (list.contains(1)) {
//					if (nums[i] > 0 && nums[k] > 0) {
//						if (nums[i] - 1 != nums[k]) {
//							return nums[k] + 1;
//						} else {
//							System.out.println("else:"+nums[i]);
//							return nums[i] + 1;
//						}
//					}
//
//				}
//
//				else {
//					return 1;
//				}
//
//				k++;
//
//			}
//		}
//
//		return -1;
//	}
//}