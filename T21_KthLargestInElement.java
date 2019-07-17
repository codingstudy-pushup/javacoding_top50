package top50;

import java.util.*;

public class T21_KthLargestInElement {

	
	public static void main(String[] args) {
		T21_KthLargestInElement a = new T21_KthLargestInElement();
		 int[] nums = {3,2,1,5,6,4};
		 int k = 2;
		 System.out.println(a.findKthLargest_pq(nums, k));
	}
	
	public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}
	
	public int findKthLargest_pq(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
}
