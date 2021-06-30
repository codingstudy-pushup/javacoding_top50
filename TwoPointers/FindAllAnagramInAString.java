package TwoPointers;

import java.util.*;

public class FindAllAnagramInAString {
	public static void main(String args[]) {
		FindAllAnagramInAString a = new FindAllAnagramInAString();
//		String src = "BACDGABCDA";
//		String trg = "ABCD";
		String src = "bacdgabcda";
		String tar = "abcd";
		System.out.println(a.solve(src, tar));
	}
	
	public List<Integer> solve(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int counter = map.size();
		int left = 0, right = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
//			System.out.println("c: " + c);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			right++;

			while (counter == 0) {
				char c2 = s.charAt(left);
				if (map.containsKey(c2)) {
					map.put(c2, map.get(c2) + 1);
					if (map.get(c2) > 0) {
						counter++;
						System.out.println("cou "+counter);
					}
				}
				if (right - left == t.length()) {
					result.add(left);
				}
			
				left++;
				
			}

		}
		return result;
	}

	public List<Integer> solve_array(String src, String tar) {
		// 1
		List<Integer> result = new ArrayList<>();
		if (src == null || src.length() == 0 || tar == null || tar.length() == 0 || src.length() < tar.length())
			return result;
		// 2
		int[] tarArr = new int[26];//
		for (int i = 0; i < tar.length(); i++) {
			tarArr[tar.charAt(i) - 'a']++;// [1,1,1,1,0,0,0.......]
		}

		for (int i = 0; i < src.length() - tar.length() + 1; i++) {
			int[] srcArr = new int[26];
			for (int j = 0; j < tar.length(); j++) {
				System.out.print(src.charAt(i + j));
				System.out.println("i " + i + " j " + j);
				srcArr[src.charAt(i + j) - 'a']++; // 0+, 1+

			}
			System.out.println();
			if (check(tarArr, srcArr)) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean check(int[] tarArr, int[] srcArr) {
		for (int i = 0; i < tarArr.length; i++) {
			if (tarArr[i] != srcArr[i]) {
				return false;
			}
		}
		return true;
	}


}
