package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/lexicographical-numbers/description/

//Walmart
public class LexographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for(char i='1';i<='9';i++)
		{
			String str = ""+i;
			dfs(str , result , n);
		}

		return result;
	}

	void dfs(String str , List<Integer> list , int n)
	{
		if(Integer.valueOf(str)>n) return;

		if(Integer.valueOf(str)<=n) list.add(Integer.valueOf(str));

		for(char i='0';i<='9';i++)
		{
			dfs(str+i , list , n);
		}
	}
}