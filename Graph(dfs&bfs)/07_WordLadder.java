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
		if (wordList == null || !wordList.contains(endWord))
			return 0;

		Queue<String> queue = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);
		queue.offer(beginWord);
		dict.add(endWord);
		dict.remove(beginWord);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				if (str.equals(endWord))
					return level;
				for (String neighbor : neighbors(str, wordList)) {
					queue.offer(neighbor);
				}
			}
			level++;
		}

		return 0;
	}

	public List<String> neighbors(String s, List<String> wordList) {

		List<String> res = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);
		for (int i = 0; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			for (char ch = 'a'; ch <= 'z'; ch++) {
				chars[i] = ch;// ait~zit
				String word = new String(chars);
				if (dict.remove(word)) {
					res.add(word);
				}
			}
		}
		return res;
	}
}

//2. 끝까지 최선님 의견에 따라서 wordList에 한번 사용한 값은 삭제하면서 찾으면 더 빠르게 찾을 수 있어서 소스를 아래로 수정합니다.
// 1. for (String neighbor : neighbors(str, dict)) { //1 호출시 set으로 호출
// 2. public List<String> neighbors(String s, List<String> wordList) 함수의 두번째 파라미터를  Set으로 변경
//   -> public List<String> neighbors(String s, Set<String> dict) 

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
		if (wordList == null || !wordList.contains(endWord))
			return 0;

		Queue<String> queue = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);
		queue.offer(beginWord);
		dict.add(endWord);
		dict.remove(beginWord);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				if (str.equals(endWord))
					return level;
				for (String neighbor : neighbors(str, dict)) { //1 호출시 set으로 호출
					System.out.println("neighbor "+neighbor);
					queue.offer(neighbor);
				}
			}
			level++;
		}

		return 0;
	}

	public List<String> neighbors(String s, Set<String> dict) {//2

		List<String> res = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			for (char ch = 'a'; ch <= 'z'; ch++) {
				chars[i] = ch;// ait~zit
				String word = new String(chars);
				if (dict.remove(word)) {
					res.add(word);
				}
			}
		}
		return res;
	}

}


