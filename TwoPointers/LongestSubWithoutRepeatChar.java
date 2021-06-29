package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubWithoutRepeatChar {

	public static void main(String[] args) {
//		String input = "pwwkea";
		String input = "abcabcd";
		System.out.println(solve_map(input));
	}
	
	public static int solve_map(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0, counter = 0, max = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			System.out.println("c: " + c);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) > 1)
				counter++;
			right++;

			while (counter > 0) {
				char charTemp = s.charAt(left);
				if (map.get(charTemp) > 1)
					counter--;
				map.put(charTemp, map.get(charTemp) - 1);
				left++;
			}
			max = Math.max(max, right - left);
			System.out.println("max "+max);
		}
		return max;
	}

	public static int solve_1(String s) {
		int[] map = new int[128];
		int start = 0, end = 0, maxLen = 0, counter = 0;

		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (map[c1] > 0) counter++;
			map[c1]++;
			end++;

			while (counter > 0) {
				char c2 = s.charAt(start);
				if (map[c2] > 1) counter--;
				map[c2]--;
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}

	

	public int solve_3(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

}
