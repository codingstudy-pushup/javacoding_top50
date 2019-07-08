package test01;

import java.util.*;

public class WordLadder {

		public static void main(String[] args) {

			Set<String> wordList = new HashSet<>();
			wordList.add("hot");
			wordList.add("dot");
			wordList.add("lot");
			wordList.add("log");
			wordList.add("cog");
			
			String[] words = {"hot","dot","lot","log","cog"};
			
			
//			System.out.println(ladderLength("hit", "cog", words));
			WordLadder a = new WordLadder();
			System.out.println(a.ladderLength("hit", "cog", wordList));
		}
		
		public int ladderLength(String b, String e, Set<String> dict) {
		    if(b.equals(e)) return 1;
		    
		    Queue<String> q = new LinkedList<String>();
		    q.add(b);
		    dict.remove(b);

		    int level=2;
		    
		    while(!q.isEmpty()) {
		        int sz = q.size();
		        
		        for(int i=0; i<sz; i++) {
		            String tmp = q.poll();
		            
		            for(int j=0; j<tmp.length(); j++) {
		                char[] chars = tmp.toCharArray();
		                
		                for(char c='a'; c<='z'; c++) {
		                    chars[j] = c;
		                    String tmp2 = new String(chars);
		                    System.out.println("tmp2: "+tmp2);
		                    
		                    if(tmp2.equals(e)) return level;
		                    
		                    if(dict.remove(tmp2)) {
		                    	System.out.println("==================tmp2: "+tmp2);
		                        q.add(tmp2);
		                    }
		                }
		            }
		        }
		        
		        level++;
		    }
		    
		    return 0;
		}
}
