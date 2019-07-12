
import java.util.*;

public class WordLadder {



		public static void main(String[] args) {

//			Set<String> wordList = new HashSet<>();
//			wordList.add("hot");
//			wordList.add("dot");
//			wordList.add("lot");
//			wordList.add("log");
//			wordList.add("cog");
			
			String[] words = {"hot","dot","lot","log","cog"};
			List<String> wordList = Arrays.asList(words);
			
//			System.out.println(ladderLength("hit", "cog", words));
			WordLadder a = new WordLadder();
			System.out.println(a.ladderLength("hit", "cog", wordList));
		}
		
		 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		        if(beginWord==null || endWord==null || beginWord.equals(endWord) || !wordList.contains(endWord)) return 0;
		        int len = 1;
		        Set<String> dict = new HashSet<>(wordList);
		        Queue<String> queue = new LinkedList<>();
		        Set<String> visited = new HashSet<>();
		        queue.offer(beginWord); visited.add(beginWord);
		        while(!queue.isEmpty()){
		            int levelSize = queue.size();
		            for(int s=0;s<levelSize;s++){
		                String cur = queue.poll();
		                for(int i=0;i<cur.length();i++){
		                    for(char c='a';c<='z';c++){
		                        char[] carr = cur.toCharArray();
		                        char c1 = carr[i];
		                        carr[i] = c;
		                        String temp = new String(carr);
		                       
		                        if(temp.equals(endWord)){
		                             System.out.println("temp "+temp +" endWord  "+endWord);
		                             return len+1;
		                        } 
		                        if(!visited.contains(temp) && dict.contains(temp)){
		                            visited.add(temp); queue.offer(temp);
		                        }
		                        carr[i] = c1;
		                    }
		                }               
		            }
		            len++;
		        }
		        
		        return 0;
		    }
 }
