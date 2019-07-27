package top50;

import java.util.Arrays;
import java.util.*;

public class WordLadder {

	public static void main(String[] args) {
		String[] words = {"hot","dot","lot","log","cog"};
//		String[] words = {"hot","dot","dog","lot","log"};
		List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
		WordLadder a = new WordLadder();
		System.out.println(a.ladderLength_neighbor("hit","cog", wordList));
	}
	
	 public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
		   if(wordList==null|| !wordList.contains(endWord))
			   return 0;
		 
	        Queue<String> queue = new LinkedList<>();
	        Set<String> dict = new HashSet<>(wordList);
	        queue.offer(beginWord);
//	        dict.add(endWord);
//	        dict.remove(beginWord);
	        int level = 1;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            System.out.println("================size "+size);
	            for(int i=0;i<size;i++){
	                String str = queue.poll();
	                System.out.println("========================str "+str);
	                if(str.equals(endWord)) {
	                	 System.out.println("=======str "+str);
	                	 System.out.println("=======endword "+endWord);
	                	return level;
	                }
	                for(String neighbor : neighbors(str,wordList)){
	                	 System.out.println("&&&&&&&&&&&&&&&&&&neighbors "+neighbor);
	                    queue.offer(neighbor);
	                }
	            }
	            level++;
	        }
	        return 0;
	    }
	    
	    public List<String> neighbors(String s, List<String> wordList){
	     	
	        List<String> res = new LinkedList<>();
	        Set<String> dict = new HashSet<>(wordList);
	        for(int i=0;i<s.length();i++){
	            char [] chars = s.toCharArray();
	            for(char ch = 'a'; ch <= 'z'; ch++){
	                chars[i] = ch;
	                String word = new String(chars);
//	                System.out.println("word "+word);
	                if(dict.remove(word)){
//	               	 System.out.println("&&&&&&&&&&&&&&&&&&word "+word);
//	                	 System.out.println("&&&&&&&&&&&&&&&&&&dict "+dict);
	                
	                    res.add(word);
	                }
	            }
	        }
	        return res;
	    }
	    
	

	 
	    

	
}

	

	 
	    

	
}
























import java.util.Arrays;
import java.util.*;

public class WordLadder {

	public static void main(String[] args) {
		String[] words = {"hot","dot","lot","log","cog"};
//		String[] words = {"hot","dot","dog","lot","log"};
		List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
		WordLadder a = new WordLadder();
		System.out.println(a.ladderLength_neighbor("hit","cog", wordList));
	}
	
	 public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
		   if(wordList==null|| !wordList.contains(endWord))
			   return 0;
		 
	        Queue<String> queue = new LinkedList<>();
	        Set<String> dict = new HashSet<>(wordList);
	        queue.offer(beginWord);
//	        dict.add(endWord);
//	        dict.remove(beginWord);
	        int level = 1;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            System.out.println("================size "+size);
	            for(int i=0;i<size;i++){
	                String str = queue.poll();
	                System.out.println("=======str "+str);
	                if(str.equals(endWord))return level;
	                for(String neighbor : neighbors(str,wordList)){
	                	System.out.println("neighbor "+neighbor);
	                    queue.offer(neighbor);
	                }
	            }
	            level++;
	        }
	        return 0;
	    }
	    
	    public List<String> neighbors(String s, List<String> wordList){
	        List<String> res = new LinkedList<>();
	        Set<String> dict = new HashSet<>(wordList);
	        for(int i=0;i<s.length();i++){
	            char [] chars = s.toCharArray();
	            for(char ch = 'a'; ch <= 'z'; ch++){
	                chars[i] = ch;
	                String word = new String(chars);
	                if(dict.remove(word)){
	                    res.add(word);
	                }
	            }
	        }
	        return res;
	    }
	    
	    
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
	
	 
	    
	 public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
	        if(beginWord==null || endWord==null || beginWord.equals(endWord) || !wordList.contains(endWord)) return 0;
	        int len = 1;
	        Set<String> dict = new HashSet<>(wordList);
	        Queue<String> queue = new LinkedList<>();
	        Set<String> visited = new HashSet<>();
	        queue.offer(beginWord); visited.add(beginWord);
	        while(!queue.isEmpty()){
	            int levelSize = queue.size();
	            System.out.println("===============levelSize"+levelSize);
	            for(int s=0;s<levelSize;s++){
	                String cur = queue.poll();
	                for(int i=0;i<cur.length();i++){
	                    for(char c='a';c<='z';c++){
	                        char[] carr = cur.toCharArray();
	                        System.out.println("first");
	                        System.out.println(carr);
	                        char c1 = carr[i];
	                        carr[i] = c;
	                        String temp = new String(carr);
	                        System.out.println("temp "+temp);
	                        if(temp.equals(endWord)){
	                             System.out.println("===========temp "+temp +" endWord  "+endWord);
	                             return len+1;
	                        } 
	                        if(!visited.contains(temp) && dict.contains(temp)){
	                            visited.add(temp); 
	                            queue.offer(temp);
	                        }
	                        carr[i] = c1;
	                        System.out.println(carr);
	                        System.out.println("");
	                    }
	                }               
	            }
	            len++;
	        }
	        
	        return 0;
	    }
	
}
