package com.example.amazonpractice;

import java.util.*;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();

		Map<String , List<String>> map = new HashMap<>();
		for(String str : strs)
		{
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String newString = new String(chars);
			if(map.containsKey(newString)) map.get(newString).add(str);
			else
			{
				List<String> list = new ArrayList<>(Arrays.asList(str));
				map.put(newString , list);
			}
		}

		for(Map.Entry<String , List<String>> m1 : map.entrySet())
		{
			result.add(m1.getValue());
		}

		return result;
	}
}