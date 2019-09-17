package zTest01;

import java.util.*;

public class RemoveInvalidParentheses01 {

	public static void main(String[] args) {
		String s = "(a)())()";
		RemoveInvalidParentheses01 a = new RemoveInvalidParentheses01();
		System.out.println(a.solve(s));
	}
	public List<String> solve(String s){
		List<String> result = new ArrayList<>();
		if(s==null) 
			return result;
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(s);
		visited.add(s);
		boolean found =false;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				String str = queue.poll();
				if(isValid(str)) {
					result.add(str);
					found = true;
					System.out.println("str: "+str+" found "+found);
				}
				System.out.println("found "+found);
				if(found) continue;
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j)!= '(' && str.charAt(j) !=')') continue;
					System.out.println(str.substring(0,j)+":"+str.substring(j+1));
					String newStr = str.substring(0,j)+str.substring(j+1);
					if(!visited.contains(newStr)) {
//						System.out.println("newStr: "+newStr);
						queue.offer(newStr);
						visited.add(newStr);
					}
				}
				System.out.println("======");
			}
		}
		return result;
	}
	private boolean isValid(String str) {
		int count=0;
		
	    for(char c : str.toCharArray()) {
	    	if(c=='(') {
	    		count++;
	    	}else if(c==')') {
	    		count--;
	    		if(count<0) return false;
	    	}
	    }
	    return count==0;
	}
	
}
