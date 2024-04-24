package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/custom-sort-string/


public class CustomSortString {
	public String customSortString(String order, String s) {
		Map<Character,Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) map.put(c , map.getOrDefault(c,0)+1);

		StringBuilder sb = new StringBuilder();

		for(char c : order.toCharArray())
		{
			if(map.containsKey(c))
			{
				int value = map.get(c);
				for(int i=0;i<value;i++) sb.append(c);
				map.remove(c);
			}
		}
		for(Map.Entry<Character,Integer> m1 : map.entrySet())
		{
			int value = m1.getValue();
			for(int i=0;i<value;i++) sb.append(m1.getKey());
		}

		return sb.toString();
	}
}