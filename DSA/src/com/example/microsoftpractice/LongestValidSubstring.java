package com.example.microsoftpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/length-of-the-longest-valid-substring/

public class LongestValidSubstring {
	static int val = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = longestValidSubstring("cbaaaabc" ,
				new ArrayList<>(Arrays.asList("aaa","cb")));
		System.out.println(result);
	}


	public static int longestValidSubstring(String word, List<String> forbidden) {
		int n = word.length();
		int max = 0;
		for(int i=0;i<n;i++)
		{
			String subStr="";
			for(int j=i;j<n;j++)
			{
				subStr += word.charAt(j);
				if(check(forbidden , subStr)) max = Math.max(max , subStr.length());
			}
		}

		return max;
	}

	private static boolean check(List<String> forbidden, String ref) {
		// TODO Auto-generated method stub
		for(String str : forbidden)
		{
			if(ref.indexOf(str) != -1) return false;
		}
		return true;
	}
}