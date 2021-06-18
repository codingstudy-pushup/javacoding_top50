package Searching;

import java.util.*;

public class KthLargestInElement {

	public static void main(String[] args) {
		KthLargestInElement a = new KthLargestInElement();
//		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int[] nums = { 2, 3, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(a.solve_pq(nums, k));
	}

	public int solve(int[] nums, int k) {
		final int N = nums.length;
		Arrays.sort(nums);
		return nums[N - k];
	}

	public int solve_pq(int[] nums, int k) {

		Queue<Integer> pq = new PriorityQueue<>();

		for (int val : nums) {
			pq.offer(val);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}
