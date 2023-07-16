package com.example.amazonpractice;

import java.util.*;

public class FindReplacePattern {

	public static void main(String[] args)
	{
		List<String> list = findAndReplacePattern(new String[] {"abc","deq","mee",
				"aqq","dkd","ccc"}, "abb");
		System.out.println(list);
	}

	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<>();

		for(String str : words)
		{
			Map<Character,Character> map = new HashMap<>();
			Set<Character> set = new HashSet<>();
			boolean flag = true;
			if(str.length() != pattern.length())
			{
				flag = false;
				break;
			}
			for(int i=0;i<str.length();i++)
			{
				char chS = str.charAt(i);
				char chM = pattern.charAt(i);
				if(!map.containsKey(chS) && !set.contains(chM)) 
				{
					map.put(chS , chM);
					set.add(chM);
				}
				else if(map.containsKey(chS) && chM != map.get(chS))
				{
					flag = false;
					break;
				}
				else if(! map.containsKey(chS) && set.contains(chM))
				{
					flag = false;
					break;
				}
			}
			if(flag) list.add(str);
		}

		return list;
	}
}