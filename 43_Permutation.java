package test03;

import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		Permutation a = new Permutation();
		int[] nums = {1,2,3};
//		System.out.println(a.permute_backTrack(nums));
		System.out.println(a.permute_dfs(nums));
	}
	
	public List<List<Integer>> permute_dfs(int[] nums) {
	    List<List<Integer>> lists = new ArrayList<>();
	    if (nums == null || nums.length == 0) {
	        return lists;
	    }

	    dfs(nums, lists, new ArrayList<Integer>());
	    return lists;
	}
	int count=0;
	private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
		count++;
		System.out.println("--start--"+cur);
		  
	    if (cur.size() == nums.length) {
	        List<Integer> list = new ArrayList<>(cur);
	        lists.add(list);
	    }

	    for (int i = 0; i < nums.length; i++) {
	   	    
	        if (cur.contains(nums[i])) {
	        	
	            continue;
	        }
//	        if (cur.size() == nums.length) {
//        	continue;
//	    }
	        System.out.println("========i: "+i+" nums[" + i + "]=" + nums[i]+" cur: "+cur+" count "+count);
	        cur.add(nums[i]);
//	        System.out.println("########i: "+i+" nums[" + i + "]=" + nums[i]+" cur: "+cur+" count "+count);
	        dfs(nums, lists, cur);
	        System.out.println("size = " + cur.size());
	        cur.remove(cur.size() - 1);
	    }
	   
	    System.out.println("--end--"+cur);
	    System.out.println();
	}
	
	
	
}
