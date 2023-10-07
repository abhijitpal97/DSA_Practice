package com.example.googlepractice;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/

public class LongestValidParenthesis {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int curr = -1;
		int longest = 0;
		if(s.length() < 2) return 0;

		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '(') stack.push(i);
			else
			{
				if(stack.isEmpty())
				{
					curr=i;
				}
				else
				{
					stack.pop();
					if(stack.isEmpty()) longest = Math.max(longest , i-curr);
					else longest = Math.max(longest , i - stack.peek());
				}

			}
		}
		return longest;
	}
}