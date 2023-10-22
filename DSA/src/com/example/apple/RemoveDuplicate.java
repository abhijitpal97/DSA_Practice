package com.example.apple;

import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/

public class RemoveDuplicate {
	public String removeDuplicateLetters(String s) {
		int[] letters = new int[26];

		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			letters[ch - 'a'] = i;
		}

		Stack<Integer> stack = new Stack<>();
		boolean[] seen = new boolean[26];

		for(int i = 0; i<s.length() ; i++)
		{
			int ch = s.charAt(i) - 'a';
			if(seen[ch]) continue;

			while(! stack.isEmpty() && 
					stack.peek()>ch && i<letters[stack.peek()])
			{
				seen[stack.pop()] = false;
			}

			stack.push(ch);
			seen[ch] = true;
		}

		StringBuilder sb = new StringBuilder();

		while(! stack.isEmpty()) sb.insert(0 , (char)(stack.pop()+'a'));

		return sb.toString();
	}
}