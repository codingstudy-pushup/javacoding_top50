package zTest;

import java.util.*;

public class ValidParentheses {

	public static void main(String[] args) {
		String exp="{()}";
		System.out.println(isValid(exp));
	}
	
	public static boolean isValid(String s) {

	    if(s.length()%2 != 0) return false;
	    Stack<Character> stack = new Stack<Character>();

	    for(int i=0; i<s.length(); i++){
	        switch(s.charAt(i)){
	            case ')':
	                if(!stack.empty()&&stack.peek()=='(') stack.pop();
	                break;
	            case ']':
	                if(!stack.empty()&&stack.peek()=='[') stack.pop();
	                break;
	            case '}':
	                if(!stack.empty()&&stack.peek()=='{') stack.pop();
	                break;
	            default:
	                stack.push(s.charAt(i));
	                break;
	        }
	        
	    }
	    
	    return stack.empty();
	}
	
	public static boolean isValid_map(String str) {
		Map<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) {
				stack.push(c);
			}else if(map.containsValue(c)) {
				if(!stack.isEmpty() && map.get(stack.peek())==c) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
}
