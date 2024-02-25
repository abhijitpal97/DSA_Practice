package com.example.leetCode75;

import java.util.Stack;

// https://leetcode.com/problems/removing-stars-from-a-string/

public class RemoveStarsFromString {
	public String removeStars(String s) {
		Stack<Character> stack = new Stack<>();
		for(char ch : s.toCharArray())
		{
			if(ch == '*' && !stack.isEmpty()) stack.pop();
			if(ch != '*') stack.push(ch);
		}

		StringBuilder sb = new StringBuilder();
		while(! stack.isEmpty()) sb.insert(0,stack.pop());

		return sb.toString();
	}
}