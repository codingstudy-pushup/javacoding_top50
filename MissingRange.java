package p1;

import java.util.ArrayList;
import java.util.List;
public class MissingRange {

	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 75};
		int lower = 0 ,upper = 99;
		System.out.println(findMissingRanges(nums, lower, upper));
	}
	
	 public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
	        List<String> result = new ArrayList<>();
	        if (nums == null || nums.length == 0){
	            result.add(showRange(lower,upper));
	            return result;
	        }

	        // 1st step
	        if (nums[0] > lower){
	            result.add(showRange(lower,nums[0]-1));
	        }

	        // 2nd step
	        for (int i = 0; i < nums.length-1; i++){
	            if (nums[i] != nums[i+1] && nums[i] +1 < nums[i+1] ) {
	                result.add(showRange(nums[i]+1, nums[i+1]-1));
	            }
	        }

	       // 3rd step
	        if (nums[nums.length-1] < upper){
	            result.add(showRange(nums[nums.length-1]+1, upper));
	        }
	        return result;
	    }
	    
	    public static String showRange(int low, int high){
	        return low == high ? String.valueOf(low) : (low + "->" + high);
	    }
	

}
