package string;

public class LicenseKeyFormatting {
	
	public static void main(String[] args) {
		String str = "8F3Z-2e-9-wabcdef";
//		String str = "8F3Z-2e-9-w";
//		String str = "8-5g-3-J";
		int k =4;
		System.out.println(solve(str, k));
	}
	
	public static String solve(String str, int k ) {
		
		//1. - del
		String newStr= str.replace("-", "");
		System.out.println("1: "+newStr);
		
		//2. upper
		newStr= newStr.toUpperCase();
		System.out.println("2: "+newStr);
		
		//3. k개로 파싱하기, 그리고 - 넣기
		StringBuilder sb = new StringBuilder(newStr);
		System.out.println("3: "+newStr);
//		"8F3Z2E9W"
		int len = sb.length();
		for(int i=k; i<len; i=i+k) {
			System.out.println("len-i: "+(len-i));
			sb.insert(len-i, '-');
			System.out.println("4: "+sb);
		}
		return sb.toString();
		
	}

}
