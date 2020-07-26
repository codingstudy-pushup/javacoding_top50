package aa_Exercise;

import java.util.*;


public class Lis {

	public static void main(String[] args) {
		
		Lis a = new Lis();
		int[] nums = {1,2,3, 2, 5, 2, 6, 10, 4, 12}; 
		System.out.println(a.solve(nums));
	}
    public int solve(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
//            	System.out.println("nums["+i+"] "+nums[i]+" nums["+j+"]"+nums[j]);
                if(nums[i]>nums[j]){
                	
                    dp[i]=Math.max(dp[j]+1,dp[i]);
//                    System.out.println("dp["+i+"] "+dp[i]+" dp["+j+"]"+dp[j]);
                }
            }
            System.out.println();
            result=Math.max(result, dp[i]);
        }
        return result;
        
    }
}
