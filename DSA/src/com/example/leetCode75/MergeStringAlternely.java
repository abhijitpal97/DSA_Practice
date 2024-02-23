package com.example.leetCode75;

// https://leetcode.com/problems/merge-strings-alternately/

public class MergeStringAlternely {
	public String mergeAlternately(String word1, String word2) {
		StringBuilder sb = new StringBuilder();
		int n = word1.length();
		int m = word2.length();

		int i = 0;
		int j = 0;

		while(i<n && j<m)
		{
			char ch = word1.charAt(i);
			char ch1 = word2.charAt(j);
			sb.append(ch).append(ch1);
			i++;
			j++;
		}
		while(i<n)
		{
			sb.append(word1.charAt(i));
			i++;
		}
		while(j<m)
		{
			sb.append(word2.charAt(j));
			j++;
		}

		return sb.toString();
	}
}