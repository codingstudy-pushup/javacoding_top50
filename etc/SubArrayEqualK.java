

//Input:nums = [1,1,1], k = 2
//Output: 2

import java.util.*;

public class SubArrayEqualK {

	public static void main(String[] args) {
		int[] nums = {1,1,1};
		int k= 2;  
		SubArrayEqualK a= new SubArrayEqualK();
		System.out.println(a.subarraySum(nums, k));
	}
	
	public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
