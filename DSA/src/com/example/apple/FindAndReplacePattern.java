package com.example.apple;

import java.util.*;

public class FindAndReplacePattern {

	public static void main(String[] args)
	{
		List<String>  res = findAndReplacePattern(
				new String[] {"abc","deq","mee","aqq","dkd","ccc"} , "abb");
		System.out.println(res);
	}

	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<>();

		for(String word : words)
		{
			Map<Character,Character> map = new HashMap<>();
			Set<Character> set = new HashSet<>();
			boolean flag = true;
			if(word.length() != pattern.length())
			{
				flag = false;
				break;
			}
			for(int i=0;i<word.length();i++)
			{
				char ch1 = word.charAt(i);
				char ch2 = pattern.charAt(i);
				if(!map.containsKey(ch1) && !set.contains(ch2))
				{
					map.put(ch1 , ch2);
					set.add(ch2);
				}
				else if(map.containsKey(ch1) &&  ch2 != map.get(ch1))
				{
					flag = false;
					break;
				}
				else if(! map.containsKey(ch1) && set.contains(ch2))
				{
					flag = false;
					break;
				}
			}
			if(flag) list.add(word);

		}

		return list;

	}
}