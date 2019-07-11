package T0710;

import java.util.*;

public class FindAllAnagrams {

		  public static void main(String args[])
		    {
		        String txt = "BACDGABCDA";
		        String pat = "ABCD";
		        System.out.println(findAnagrams(txt, pat));
		    }
		
		
		 public static List<Integer> findAnagrams(String s, String p) {
		        List<Integer> rst = new ArrayList<>();
		        if (s == null || s.length() == 0 || s.length() < p.length()) {
		            return rst;
		        }

		        int[] map_p = new int[256];
		        for (int i = 0; i < p.length(); i++) {
//		            map_p[p.charAt(i) - 'A']++;
		            map_p[p.charAt(i) ]++;
		        }

		        for (int i = 0; i < s.length() - p.length()+1; i++) {
		            int[] map_s = new int[256];
		            for (int j = 0; j < p.length(); j++) {
		            	System.out.println("i: "+i+" j: "+j+" i+j: "+(i+j));
		            	System.out.println("s.charAt(i+j): "+s.charAt(i+j));
		                map_s[s.charAt(i+j)]++;
		            }
		            System.out.println();
		            if (isMatch(map_p, map_s)) {
		            	System.out.println("true");
		                rst.add(i);
		            }
		        }
		        return rst;
		    }

		    public static boolean isMatch(int[] arr1, int[] arr2) {
		        for (int i = 0; i < arr1.length; i++) {
		            if (arr1[i] != arr2[i]) {
		                return false;
		            }
		        }
		        return true;
		    }

}
