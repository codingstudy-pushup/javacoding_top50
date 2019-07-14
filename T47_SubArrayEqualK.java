package top50;

import java.util.*;

public class T47_SubArrayEqualK {
	
	public static void main(String[] args) {
		T47_SubArrayEqualK a= new T47_SubArrayEqualK();
//		int[] nums = {1,1,1};
//		int k =2;
		
		int[] nums = {10, 2, -2, -20, 10};
		//Subarrays: arr[0...3], arr[1...4], arr[3..4]
		int k = -10;
		System.out.println(a.subarraySum(nums, k));
	}

	public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            if(sum==k){
                count++;
            }
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
	
	 public int subarraySum2(int[] A, int S) {
	        int sum = 0;
			int ans = 0;
			HashMap<Integer, Integer> map = new HashMap<>();

			map.put(0, 1);

			for (int val : A) {
				sum += val;
				ans += map.getOrDefault(sum - S, 0);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}

			return ans;
	    }
}
