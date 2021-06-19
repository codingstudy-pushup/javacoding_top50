package Searching;

public class MoveZero_end {

	public static void main(String args[]) {

		int[] nums = { 0, 3, 2, 0, 8, 5 };
		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		while (index < nums.length) {
			nums[index] = 0;
			index++;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
  

//2
		int[] nums = { 0, 3, 2, 0, 8, 5 };
		int index = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index--;
			}
		}

		while (index >= 0) {
			nums[index] = 0;
			index--;
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	
}

}
