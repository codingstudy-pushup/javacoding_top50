package Searching;

import java.util.*;

public class KthLargestInElement {

	public static void main(String[] args) {
		KthLargestInElement a = new KthLargestInElement();
//		int[] nums = { 2, 3, 1, 5, 6, 4 };
//		int k = 2;
		
		int[] nums = { 3,2,3,1,2,4,5,5,6 };
		int k = 4;
		System.out.println(a.solve(nums, k));
		System.out.println(a.solve_pq(nums, k));
	}

	public int solve(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;//6
		return nums[n-k]; //6-2=4
		
	}

	public int solve_pq(int[] nums, int k) {
		
		//1
		Queue<Integer> pq = new PriorityQueue<>();
		
		//2
		for(int i: nums) {
			pq.offer(i);
			if(pq.size() >k) {
				pq.poll();
			}
		}
		return pq.peek();
		
	}
	
	
	
	
	
	
}
