package Top50_test;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

	
	public static void main(String[] args) {
		ContainDuplicate a = new ContainDuplicate();
		int[] nums = {1,2,3,1};
		System.out.println(a.containsDuplicate1(nums));
	}
	public boolean containsDuplicate1(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
            	System.out.println("nums["+i+"]: "+ nums[i]+" nums["+j+"]: "+nums[j]);
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
	
	 public boolean containsDuplicate3(int[] nums) {

	        Arrays.sort(nums);
	        for(int ind = 1; ind < nums.length; ind++) {
	            if(nums[ind] == nums[ind - 1]) {
	                return true;
	            }
	        }
	        return false;
	    }
	 
	 public boolean containsDuplicate2(int[] nums) {

		    final Set<Integer> distinct = new HashSet<Integer>();
		    for(int num : nums) {
		        if(distinct.contains(num)) {
		            return true;
		        }
		        distinct.add(num);
		    }
		    return false;
		}
}
