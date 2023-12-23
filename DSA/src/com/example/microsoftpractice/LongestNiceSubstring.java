package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/longest-nice-substring/

public class LongestNiceSubstring {
	public String longestNiceSubstring(String s) {
		if(s.length()<=1) return "";
		Set<Character> set = new HashSet<>();

		for(char ch : s.toCharArray()) set.add(ch);

		for(int i=0; i<s.length() ; i++)
		{
			char ch = s.charAt(i);

			if(set.contains(Character.toUpperCase(ch)) 
					&& set.contains(Character.toLowerCase(ch))) continue;

			String s1 = longestNiceSubstring(s.substring(0 , i));
			String s2 = longestNiceSubstring(s.substring(i+1));

			if(s1.length() >= s2.length()) return s1;
			return s2;
		}

		return s;
	}
}