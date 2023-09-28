package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

public class MinRemoveToMakeParenthesisValid {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> set = new HashSet<>();

		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '(') stack.push(i);
			else if( stack.isEmpty() && s.charAt(i) == ')') set.add(i);
			else if(s.charAt(i) == ')') stack.pop();
		}

		while(! stack.isEmpty()) set.add(stack.pop());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			if(! set.contains(i)) sb.append(s.charAt(i));
		}

		return sb.toString();
	}
}