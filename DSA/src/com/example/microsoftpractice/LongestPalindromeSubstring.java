package com.example.microsoftpractice;

// https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindromeSubstring {
	public String longestPalindrome(String s) {

		int start = 0;
		int end = 0;
		for(int i=0;i<s.length();i++)
		{
			int len1 = palindromeHelper(i , i , s);
			int len2 = palindromeHelper(i , i+1 , s);
			int len = Math.max(len1 , len2);
			if(len>end-start)
			{
				start = i - (len-1)/2;
				end = i+(len/2);
			}
		}

		return s.substring(start , end+1);

	}

	int palindromeHelper(int start , int end , String s)
	{
		if(s.length() ==0 || start>end) return 0;

		while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end))
		{
			end++;
			start--;
		}

		return end-start-1;
	}
}