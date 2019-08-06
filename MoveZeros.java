package top50;

public class MoveZeros {

	public static void main(String args[]) {
		// 1
		int[] nums = { 0, 3, 2, 0, 8, 5 };
		// 2
		int currentIndex = 0;
		// 3
		for (int i = 0; i < nums.length; i++) {
			// 4
			if (nums[i] != 0) {
				nums[currentIndex] = nums[i];
				currentIndex++;
			}
		}
		// 5
		while (currentIndex < nums.length) {
			nums[currentIndex] = 0;
			currentIndex++;
		}
		// 6
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
