package Array;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(solve(nums));

	}

	public static int solve(int[] nums) {
		//1
		int curMax = nums[0];
		int allMax = nums[0];
		
		//2
		for(int i=1; i<nums.length; i++) {
			curMax = Math.max(nums[i], curMax+nums[i]);
			allMax = Math.max(allMax, curMax);
		}
		return allMax;

	}

}
