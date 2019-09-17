package test01;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses a = new ValidParentheses();
		String str = "]}[{";
//		String str = "";
		System.out.println(a.isValid(str));
	}
	public boolean isValid(String s) {
	    if(s==null||s.length()%2==1)
	        return false;
	    Stack<Character> stack = new Stack<>();
	    for(int i=0;i<s.length();i++){
	    	System.out.println("s: "+s.length());
	        char c = s.charAt(i);
	        if(c=='['||c=='{'||c=='(')
	            stack.push(c);
	        else{
	            if(stack.isEmpty())
	                return false;
	            else if(c==']' && stack.pop()!='[')
	                return false;
	            else if(c==')' && stack.pop()!='(')
	                return false;
	            else if(c=='}' && stack.pop()!='{')
	                return false;
	        }
	    }
	    return stack.isEmpty();
	}
}
