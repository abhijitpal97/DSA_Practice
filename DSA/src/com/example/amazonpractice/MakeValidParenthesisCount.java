package com.example.amazonpractice;

import java.util.Stack;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

public class MakeValidParenthesisCount {
	public int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();

		int count = 0;
		for(char ch : s.toCharArray())
		{
			if(ch == '(') stack.push(')');
			else
			{
				if(!stack.isEmpty()) stack.pop();
				else count++;
			}
		}

		return count+stack.size();
	}
}