package com.example.microsoftpractice;

import java.util.*;

public class LongestSubStringKRepeatingChars {
	public int longestSubstring(String s, int k) {
		int n = s.length();
		if(n == 0 || n<k) return 0;
		if(k<=1) return n;

		Map<Character,Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);

		int index = 0;        
		while(index<n && map.get(s.charAt(index))>=k) index++;
		if(index>=n-1) return index;

		int first = longestSubstring(s.substring(0 , index) , k);
		while(index<s.length() && map.get(s.charAt(index))<k) index++;
		int second = (index<n)?longestSubstring(s.substring(index) , k) : 0;

		return Math.max(first , second);
	}


}