package com.example.leetCode75;

// https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if(s.length()==0) return true;

		int n = t.length();
		int index = 0;
		for(int i=0;i<n; i++)
		{
			if(t.charAt(i) == s.charAt(index)) index++;
			if(index == s.length()) return true;
		}
		return index == s.length();
	}
}