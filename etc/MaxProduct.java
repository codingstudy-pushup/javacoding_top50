package zTest01;


public class MaxProduct {

	public static void main(String[] args) {
//		int[] nums = {2,3,-2,4};
		int[] nums = {-2,1,2,-3,1,3};
		MaxProduct a = new MaxProduct();
		System.out.println(a.maxProduct(nums));
	}
	public int maxProduct(int[] nums) {
	    if (nums.length == 0) {
	        return 0;
	    }
	    
	    int maxhere_pre = nums[0];
	    int minhere_pre = nums[0];
	    int maxSofar = nums[0];
	    int maxhere, minhere;
	    
	    for (int i = 1; i < nums.length; i++) {
	    	maxhere = Math.max(Math.max(maxhere_pre * nums[i], minhere_pre * nums[i]), nums[i]);
	        minhere = Math.min(Math.min(maxhere_pre * nums[i], minhere_pre * nums[i]), nums[i]);
	        maxSofar = Math.max(maxhere, maxSofar);
	        maxhere_pre = maxhere;
	        minhere_pre = minhere;
	    }
	    return maxSofar;
	}
}
