package Array;

import java.util.*;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {

		String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println("re "+groupAnagrams(list));
//		System.out.println(groupAnagrams_ascii(list));
	}
	//1. 
	public static List<List<String>> groupAnagrams(String[] strs) {
		// 1
		List<List<String>> result = new ArrayList<>();
		if (strs == null || strs.length == 0)
			return result;
		Map<String, List<String>> map = new HashMap<>();

		// 2
		for (String str : strs) {
			System.out.println("str: " + str);
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			System.out.println(charArray);
			String key = String.valueOf(charArray);
			System.out.println("key " + key);

//			if (map.containsKey(key)) {
//				map.get(key).add(str);
//			} else {
//				List<String> list = new ArrayList<>();
//				list.add(str);
//				map.put(key, list);
//			}
			List<String> list = map.getOrDefault(key, new ArrayList<>());
			list.add(str);
			map.put(key, list);
		}
		return new ArrayList<>(map.values());
//		result.addAll(map.values());
//		 for (Map.Entry<String, List<String>> entry : map.entrySet())
//			 result.add(entry.getValue());
//		return result;
	}
//2.
	public static List<List<String>> groupAnagrams_ascii(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
	
		for (String str : strs) {
			int[] count = new int[26];
			for (int k = 0; k < str.length(); k++)
				count[str.charAt(k) - 'a']++;
			String key = Arrays.toString(count);
			System.out.println("hash " + key);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		result.addAll(map.values());
		return result;
	}



}
