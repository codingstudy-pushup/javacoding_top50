package top50;

import java.util.*;
import java.util.List;

public class T17_GroupAnagrams {
	
	 public static void main(String[] args) {
			
			String[] list =  {"eat", "tea", "tan", "ate", "nat", "bat"};
	
			
			System.out.println(groupAnagrams(list));
		}
	
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
	        List<List<String>> result = new ArrayList<>();
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        for(String str : strs) {
				char[] arr = new char[256];
				for(int i=0; i<str.length(); i++) {
					arr[str.charAt(i)]++;
				}
				String ns = new String(arr);
				System.out.println("ns: "+ns);
				
				if(map.containsKey(ns)) {
					map.get(ns).add(str);
				}else {
					ArrayList<String> al = new ArrayList<>();
					al.add(str);
					map.put(ns, al);
				}
			}
	         result.addAll(map.values());
	         return result;
//	        return new ArrayList<List<String>>(map.values());
	    }
	
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String keyStr = String.valueOf(ca);
	            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
	            map.get(keyStr).add(s);
	        }
	        return new ArrayList<List<String>>(map.values());
	    }
}
