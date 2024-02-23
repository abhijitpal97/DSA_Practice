package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/different-ways-to-add-parentheses/description/

public class DifferentWaysAddParentheses {
	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> list = new ArrayList<>();

		for(int i=0 ; i<expression.length() ; i++)
		{
			char ch = expression.charAt(i);

			if(ch == '-' || ch == '+' || ch == '*')
			{
				List<Integer> left = diffWaysToCompute(expression.substring(0 , i));
				List<Integer> right = diffWaysToCompute(expression.substring(i+1));

				for(int j : left)
				{
					for(int k : right)
					{
						if(ch == '-') list.add(j-k);
						else if(ch == '+') list.add(j+k);
						else if(ch == '*') list.add(j*k);
					}
				}
			}
		}

		if(list.size() == 0) list.add(Integer.valueOf(expression));

		return list;
	}
}