package top50;

import java.util.*;

public class RemoveInvalidParentheses {

	
	public static void main(String[] args) {
//		String s = "()())()";
		String s = "(a)())()";
		RemoveInvalidParentheses a = new RemoveInvalidParentheses();
		System.out.println(a.removeInvalidParentheses(s));
		
	}
	 public List<String> removeInvalidParentheses(String s) {
	        List<String> res = new ArrayList<>();
	        if (s == null){
	            return res;
	        }
	        Queue<String> queue = new LinkedList<>();
	        Set<String> visited = new HashSet<>();
	        queue.offer(s);
	        visited.add(s);
	        boolean found = false;
	        while(!queue.isEmpty() && !found){
	            int size = queue.size();
	            for (int j = 0; j < size; j++){
	                String curr = queue.poll();
	                if (isValid(curr)){
	                    res.add(curr);
	                    found = true;
	                }
	                if (!found){
	                    for (int i = 0; i < curr.length(); i++){
	                        char c = curr.charAt(i);
	                        if (Character.isLetter(c)){
	                            continue;
	                        }
	                        String str = curr.substring(0, i) + curr.substring(i+1);
	                        if (!visited.contains(str)){
	                            queue.offer(str);
	                            visited.add(str);
	                        }
	                    }
	                }
	            }            
	        }
	        return res;
	    }
	    private boolean isValid(String str){
	        int count = 0;
	        for (char c : str.toCharArray()){
	            if (c == '('){
	                count++;
	            }else if (c == ')'){
	                count--;
	                if (count < 0){
	                    return false;
	                }
	            }
	        }
	        return count == 0;
	    }
	
}
