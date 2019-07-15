

import java.util.ArrayList;
import java.util.List;
public class T22_MissingRange {

	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 75};
		int lower = 0 ,upper = 99;
		System.out.println(findMissingRanges(nums, upper, upper));
	}
	
	 public static List<String> findMissingRanges(int[] A, int lower, int upper) {
	        List<String> result = new ArrayList<String>();
	        int pre = lower - 1;
	        for(int i = 0 ; i <= A.length  ; i++){
	            int after = i == A.length ? upper + 1 : A[i]; 
	            System.out.println("after: "+after);
	            if(pre + 2 == after){
	                result.add(String.valueOf(pre + 1));
	            }else if(pre + 2 < after){
	                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
	            }
	            pre = after;
	        }
	        return result;
	    }
}
