package Top50_test;

public class T18_PlusOne {

	
	public static void main(String[] args) {
//		int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
		int[] digits = {0,0};
//		int[] digits = {9,0,0,9};
		
		int[] result = plusOne2(digits);
		for (int i : result)
			System.out.println("val: " + i);
	}
	
	  public static int[] plusOne2(int[] digits) 
	    {
	        int carry = 1;
	        int index = digits.length - 1;
	        while (index >= 0 && carry > 0)
	        {
	            digits[index] = (digits[index] + carry) % 10;
	            
	            if(digits[index]==0) {
	            	carry =1;
	            }else {
	            	carry =0;
	            }
	            index--;
	        }
	        
	        if (carry > 0)
	        {
	            digits = new int[digits.length + 1];
	            digits[0] = 1;
	        }
	        
	        return digits;
	    }
}
