

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		 String s = "leetcode";
		 Set<String> set = new HashSet<>();
		 set.add("leet");
		 set.add("code");
		 G109_WordBreak a = new G109_WordBreak();
		 System.out.println(a.wordBreak_dp(s, set));
		 
	}
	
	public boolean wordBreak_dp(String s, Set<String> wordDict) {
	    if (s == null && wordDict == null)
	        return true;
	    if (s == null || wordDict == null)
	        return false;
	    //dp[i] represents if s.substring(0, i) is wordbreakable.
	    boolean[] dp = new boolean[s.length()+1];
	    dp[0] = true;
	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 0; j < i; j++) {
	        	System.out.println("val: "+s.substring(j, i));
	            if (dp[j] && wordDict.contains(s.substring(j, i))) {
	                dp[i] = true;
	                break;
	            }
	        }
	        System.out.println();
	    }
	    return dp[s.length()];
	}
