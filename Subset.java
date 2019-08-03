package top50;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	
	public static void main(String[] args) {
		Subsets a = new Subsets();
		int[] nums = {1,2,3};

		System.out.println(a.subsets(nums));
	}
	
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> list = new ArrayList<>();
	    if(nums==null || nums.length==0)
	    	return result;
	    dfs(result, list, nums, 0);
	   
	    return result;
	}
	private void dfs(List<List<Integer>> lists, List<Integer> cur,int[] nums, int start) {
		//1 담는거

			List<Integer> list = new ArrayList<>(cur);
			lists.add(list);
	
		
		//2 for 저장, 탈출
		for(int i=start; i<nums.length; i++) {
			
			cur.add(nums[i]);
			dfs(lists, cur, nums,i+1 );
			cur.remove(cur.size()-1);
		}
	}
}
