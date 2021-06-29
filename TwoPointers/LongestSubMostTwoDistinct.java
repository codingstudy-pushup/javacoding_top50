package TwoPointers;

import java.util.*;

public class LongestSubMostTwoDistinct {

	public static void main(String[] args) {
		String s = "ccaabbb";
		System.out.println(solve2(s));
	}

	public static int solve(String s) {
		// 1
		int left = 0, right = 0, max = 0, counter = 0;
		Map<Character, Integer> map = new HashMap<>();

		// 2
		while (right < s.length()) {
			char rightChar = s.charAt(right);
			map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);// c=2, a=2, b=3
			if (map.get(rightChar) == 1)
				counter++;
			right++;
			// 3
			while (counter > 2) {
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				if (map.get(leftChar) == 0)
					counter--;
				left++;
			}
			max = Math.max(max, right - left);
		}
		return max;
	}

	public static int solve2(String s) {
		int[] map = new int[128];
		int left = 0, right = 0, maxLen = 0, counter = 0;

		while (right < s.length()) {
			final char c1 = s.charAt(right);
			if (map[c1] == 0)
				counter++;
			map[c1]++;
			right++;

			while (counter > 2) {
				final char c2 = s.charAt(left);
				if (map[c2] == 1)
					counter--;
				map[c2]--;
				left++;
			}

			maxLen = Math.max(maxLen, right - left);
		}

		return maxLen;
	}

}
