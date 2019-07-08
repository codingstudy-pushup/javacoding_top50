package top50;

public class PlusOne {

	
	public static void main(String[] args) {
		int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
		int[] result = plusOne(digits);
		for(int i:result)
			System.out.println("val: "+i);
	}
	public static int[] plusOne(int[] digits) {
	    for (int i = digits.length - 1; i >=0; i--) {
	        if (digits[i] != 9) {
	            digits[i]++;
	            break;
	        } else {
	            digits[i] = 0;
	        }
	    }
	    if (digits[0] == 0) {
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	    return digits;
	}
}
