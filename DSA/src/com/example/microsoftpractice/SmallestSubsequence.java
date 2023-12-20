package com.example.microsoftpractice;
// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/

import java.util.*;

public class SmallestSubsequence {
	public String smallestSubsequence(String s) {
		char[] chars = new char[26];

		for(char ch : s.toCharArray())
		{
			chars[ch-'a']++;
		}

		Stack<Character> stack = new Stack<>();
		boolean[] isVisited = new boolean[26];

		for(char ch : s.toCharArray())
		{
			chars[ch-'a']--;

			if(isVisited[ch-'a']) continue;

			while(! stack.isEmpty() && ch<stack.peek() && chars[stack.peek() - 'a'] > 0) 
			{
				isVisited[stack.pop() - 'a'] = false;
			}

			stack.push(ch);

			isVisited[ch-'a'] = true;
		}

		StringBuilder sb = new StringBuilder();

		while(! stack.isEmpty()) sb.insert(0 , stack.pop());

		return sb.toString();
	}
}