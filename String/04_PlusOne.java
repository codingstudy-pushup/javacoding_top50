package string;

public class PlusOne {


	public static void main(String[] args) {
		int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
//		int[] digits = {0,0};
//		int[] digits = {9,0,0,9};
//		int[] digits = {9,9,9,9,9};
		
		
		int[] result = solve(digits);
		for (int i : result)
			System.out.println("val: " + i);
	}
	
    public static int[] solve(int[] digits) {
        int n = digits.length;        

        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;

            if (digits[i] < 10) {
                return digits;
            }

            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}
