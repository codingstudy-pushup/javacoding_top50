package TwoPointers;

import java.util.*;

public class FindAllAnagramInAString {
	public static void main(String args[]) {
		FindAllAnagramInAString a = new FindAllAnagramInAString();
//		String txt = "BACDGABCDA";
//		String pat = "ABCD";
		String txt = "bacdgabcda";
		String pat = "abcd";
		System.out.println(a.findAnagrams(txt, pat));
	}

	public List<Integer> findAnagrams(String s, String t) {
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
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			right++;

			while (counter == 0) {
				char tempc = s.charAt(left);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
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
}
