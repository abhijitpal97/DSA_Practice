package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/extra-characters-in-a-string/description

public class ExtraCharacterInString {
	int min = Integer.MAX_VALUE;

	// Recursive
	public int minExtraChar(String s, String[] dictionary) {
		min = Integer.MAX_VALUE;
		List<String> list = new ArrayList<>();
		for(String str : dictionary) list.add(str);
		function(s , list , 0);
		return min==Integer.MAX_VALUE?-1:min;
	}

	void function(String str , List<String> dict , int extra)
	{
		if(str.length()==0)
		{
			min = Math.min(min,extra);
			return;
		}

		for(String s : dict)
		{
			if(str.indexOf(s) == 0)
			{
				function(str.substring(s.length()) , dict,extra);
			}
			else
			{
				function(str.substring(1) , dict , extra+1);
			}
		}
	}


	// Memorization
	public int minExtraCharMemo(String s, String[] dictionary) {
		List<String> list = new ArrayList<>();
		for(String str : dictionary) list.add(str);
		Integer[] dp = new Integer[s.length()];
		return functionMemo(s , list , 0 , dp);
	}

	int functionMemo(String str , List<String> dict , int index , Integer[] dp)
	{
		if(index == str.length()) return 0;
		if(dp[index] != null) return dp[index];
		if(dict.contains(str.substring(index , str.length()))) return 0;

		int min = Integer.MAX_VALUE;

		for(int i=index+1 ; i<=str.length() ; i++)
		{
			int count = dict.contains(str.substring(index , i))?0:i-index;

			count+= functionMemo(str , dict , i , dp);

			min  = Math.min(min , count);
		}

		return dp[index] = min;
	}
}