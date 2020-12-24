package zTest;

import java.util.*;

public class ValidParentheses {

	public static void main(String[] args) {
		//String str= "()[]{}"  ;//true;
		//String str= "(}"  ;//false;
		String exp = "([}}])";
		System.out.println(solve(exp));
	}
	
	
	public static boolean solve(String str) {
		Stack<Character> stack = new Stack<>();
		for(char c: str.toCharArray()) {
			System.out.println("c: "+c);
			if(c=='(') {
				stack.push(')');
			}else if(c=='[') {
				stack.push(']');
			}else if(c=='{') {
				stack.push('}');
			}else if(stack.isEmpty()|| stack.pop() != c) {
				return false;
			}
			
		}
		return stack.isEmpty();
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
