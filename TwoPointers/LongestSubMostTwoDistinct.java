package TwoPointers;

import java.util.*;

public class LongestSubMostTwoDistinct {

	public static void main(String[] args) {
		String s = "ccaabbb";
		System.out.println(solve_map(s));
	}

	public static int solve_map(String s) {
		// 1
		Map<Character, Integer> map = new HashMap<>();
		int l = 0, r = 0, max = 0, counter = 0;

		// 2
		while (r < s.length()) {
			char c = s.charAt(r);
//			System.out.println("c: " + c);
			map.put(c, map.getOrDefault(c, 0) + 1);// c=2, a=2, b=3
			if (map.get(c) == 1)
				counter++;
			r++;
			// 3
			while (counter > 2) {
				char c2 = s.charAt(l);
				map.put(c2, map.get(c2) - 1);
				if (map.get(c2) == 0)
					counter--;
				l++;
			}
			max = Math.max(max, r - l);
			System.out.println("right " + r + " - left " + l + " :" + (r - l));
		}
		return max;
	}

	public static int solve2(String s) {
		int[] map = new int[128];
		int left = 0, right = 0, maxLen = 0, counter = 0;

		while (right < s.length()) {
			char c1 = s.charAt(right);

			if (map[c1] == 0)
				counter++;
			map[c1]++;
			right++;

			while (counter > 2) {
				char c2 = s.charAt(left);
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
