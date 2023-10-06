package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LongestSubStringWithoutRepeatation {
	public int lengthOfLongestSubstring(String s) {
		int longest = 0;

		Queue<Character> queue = new LinkedList<>();

		for(char ch : s.toCharArray())
		{
			if(! queue.contains(ch))
			{
				queue.offer(ch);
				longest = Math.max(longest , queue.size());
			}
			else
			{
				while(queue.contains(ch)) queue.poll();
				queue.offer(ch);
			}
		}

		return longest;
	}
}