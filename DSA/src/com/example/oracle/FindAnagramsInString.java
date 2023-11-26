package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

public class FindAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		int n = p.length();
		int m = s.length();
		int start = 0;
		int end = start+n-1;
		List<Integer> list = new ArrayList<>();
		if(n>m) return list;

		while(end < m)
		{
			if(isAnagram(s.substring(start , end+1) , p)) list.add(start);
			start++;
			end++;
		}
		return list;
	}

	boolean isAnagram(String s , String t)
	{
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		s = new String(chars);
		char[] tchars = t.toCharArray();
		Arrays.sort(tchars);
		t = new String(tchars);

		return s.equals(t);
	}
}