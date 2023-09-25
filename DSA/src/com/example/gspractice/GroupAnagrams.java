package com.example.gspractice;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/description/

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String , List<String>> map = new HashMap<>();
		for(String str : strs)
		{
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String newStr = new String(ch);

			if(map.containsKey(newStr))
			{
				map.get(newStr).add(str);
			}
			else 
			{
				List<String> temp = new ArrayList<>();
				temp.add(str);
				map.put(newStr , temp);
			}
		}
		List<List<String>> result = new ArrayList<>();

		for(Map.Entry<String,List<String>> m1 : map.entrySet())
		{
			result.add(m1.getValue());
		}

		return result;
	}
}