package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/reverse-vowels-of-a-string/

public class ReverseVowels {
	public String reverseVowels(String s) {
		List<Character> list = new ArrayList<>(Arrays.asList('a','e','i','o','u', 'A','E','I','O','U'));
		char[] chars =  s.toCharArray();

		int start = 0;
		int end = s.length()-1;

		while(start<end)
		{
			while(start<s.length() && ! list.contains(s.charAt(start))) start++;
			while(end >=0 && ! list.contains(s.charAt(end))) end--;

			if(start>end) continue;
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			//System.out.println(temp + " - "+start+" - "+end);
			start++;
			end--;
		}

		return new String(chars);
	}
}