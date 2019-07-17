package top50;

import java.util.*;

public class T21_KthLargest {
	

	public static void main(String[] args) {
		T21_KthLargest a = new T21_KthLargest();
		int[] nums = {3,2,1,5,6,4};
		int k =2;
		System.out.println(a.solve(nums , k));
		System.out.println(a.solve_pq(nums , k));
	}
	public int solve(int[] nums , int k) {
		int n = nums.length;
		Arrays.sort(nums);
		print(nums);
		return nums[n-k];
	}
	public void print(int[] nums) {
		for(int i:nums)
			System.out.println("i "+i);
	}
	
	public int solve_pq(int[] nums , int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> a-b);
		
		for(int val : nums) {
			pq.offer(val);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
		
	
	}
	Comparator<Integer> Comp = new Comparator<Integer>() {

		@Override
		public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			return a-b;
		}
		
	};
}
