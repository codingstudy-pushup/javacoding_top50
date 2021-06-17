package string;

public class LicenseKeyFormatting {
	
	public static void main(String[] args) {
		String str = "8F3Z-2e-9-wabcdef";
//		String str = "8-5g-3-J";
		int k =5;
		solve(str, k);
	}
	
	public static String solve(String str, int k ) {
		String newStr = str.replace("-", "");
		System.out.println("newStr: "+newStr);
		
		newStr = newStr.toUpperCase();
		System.out.println("newStr: "+newStr);
		
		int leng = newStr.length();
		System.out.println("leng: "+leng);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<leng; i++) {
			sb.append(newStr.charAt(i));
		}
		System.out.println("sb: "+sb);
		
		//4,8,12
		for(int i=k; i<leng; i=i+k) {
		  System.out.println("leng-i: "+(leng-i));
		  sb.insert(leng-i, '-');
		}
		System.out.println("--sb: "+sb);
		
		
		return newStr;
		
		
		
	}

}
