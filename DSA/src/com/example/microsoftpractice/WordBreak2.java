package com.example.microsoftpractice;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/word-break-part-23249/1

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> list = new ArrayList<>();
		function(s,wordDict,list, new ArrayList<>());
		return list;
	}

	void function(String s , List<String> wordDict, List<String> list , List<String> wd)
	{
		if(s.length() == 0)
		{
			StringBuilder sb = new StringBuilder();
			for(String str : wd) sb.append(str).append(" ");
			list.add(sb.substring(0 , sb.length()-1));
			return;
		}

		for(String str : wordDict)
		{
			if(s.indexOf(str) == 0)
			{
				wd.add(str);
				function(s.substring(str.length()) , wordDict , list , wd);
				wd.remove(wd.size()-1);
			}
		}
	}
}