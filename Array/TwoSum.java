package Array;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {

		TwoSum a = new TwoSum();
		int[] nums = { 2, 8, 11, 14 };
		int target = 16;
//		int[] result = a.solve_for(nums, target);
		int[] result = a.solve(nums, target);
		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}
	
	
	//O(n)
	public int[] solve(int[] nums, int target) {
		//1. ds
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		//2. for
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int val = map.get(nums[i]); //14
				result[0] =val +1;
				result[1] = i+1;
			}else {
				map.put(target-nums[i], i);
			}
		}
		return result;
		
	}
	
	
	//O(n^2)
	public int[] solve_for(int[] nums, int target) {
			
		int len = nums.length;
		
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				if(target == nums[i]+nums[j]) {
					return new int[] {i+1,j+1};
				}
			}
		}
		
		return new int[] {0,0};
	}
	
	
	
	
	

}
