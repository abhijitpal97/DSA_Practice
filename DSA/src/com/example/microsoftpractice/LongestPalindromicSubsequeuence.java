package com.example.microsoftpractice;

// https://leetcode.com/problems/longest-palindromic-subsequence/description/

public class LongestPalindromicSubsequeuence {
	public int longestPalindromeSubseq(String s) {
		String str = "";
		int len = s.length();
		for(int i = len-1;i>=0;i--) str +=s.charAt(i);

		return lcs(s,str,len,len);
	}

	int lcs(String s1 , String s2 , int n , int m)
	{
		Integer[][] dp = new Integer[n+1][m+1];
		return function(s1,s2,n,m,dp);
	}

	int function(String s1 , String s2 , int n , int m , Integer[][] dp)
	{
		if(n == 0 || m == 0) return 0;
		if(dp[n][m] != null) return dp[n][m];

		int l = 0;
		int mi = 0;
		int r = 0;

		if(s1.charAt(0) == s2.charAt(0))
		{
			l = 1+function(s1.substring(1),s2.substring(1) , n-1 , m-1 , dp);
		}
		else
		{
			mi = function(s1.substring(1),s2,n-1,m,dp);
			r = function(s1,s2.substring(1),n,m-1,dp);
		}

		return dp[n][m] = Math.max(l , Math.max(mi , r));
	}
}