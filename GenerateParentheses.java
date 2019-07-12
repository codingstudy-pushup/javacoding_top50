package top50;

import java.util.*;

public class GenerateParentheses {

	
	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
//		System.out.println(a.generateParenthesis_backTrac(3));
		System.out.println(a.generateParenthesis_dfs(3));
	}
	
	  int count =0;
	  public List<String> generateParenthesis_dfs(int n) {
	        List<String> res = new ArrayList<>();
	        dfs(res, "", n, n,"");
	        return res;
	    }
	    
	    private void dfs(List<String> list, String str, int left, int right, String str1) {
	     	count++;
	    	System.out.println("str\t"+str+"\t left: "+left+" right: "+right+" count: "+count+" str1: "+str1);
	    	
	        if (left < 0 || left > right) {
	            return;
	        }
//	        System.out.println("str: "+str);
	        System.out.println("=str\t"+str+"\t left: "+left+" right: "+right+" count: "+count);
	        if (left == 0 && right == 0) {
	            list.add(str);
	            return;
	        }
	        dfs(list, str + '(', left - 1, right, str1+"+");
	        dfs(list, str + ')', left, right - 1, str1+"-");
	    }
}
