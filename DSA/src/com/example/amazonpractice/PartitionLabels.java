package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {
		List<Integer> list = new ArrayList<>();
		if(s.length() == 0) return list;
		Map<Character,Integer> map = new HashMap<>();

		for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);


		Set<Character> set = new HashSet<>();
		String str="";
		for(int i = 0 ;i<s.length();i++)
		{
			char ch = s.charAt(i);
			str += ch;
			map.put(ch , map.get(ch)-1);
			if(map.get(ch) > 0) set.add(ch);
			else
			{
				map.remove(ch);
				if(set.contains(ch)) set.remove(ch);
				if(set.isEmpty())
				{
					list.add(str.length());
					str="";
				}
			}
		}

		return list;
	}
}