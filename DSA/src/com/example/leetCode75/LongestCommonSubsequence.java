package com.example.leetCode75;

// https://leetcode.com/problems/longest-common-subsequence/

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		Integer[][] dp = new Integer[n+1][m+1];

		return function(text1 , text2 , n , m , 0 , 0 , dp);
	}

	int function(String s1 , String s2 , int n , int m , int x , int y , Integer[][] dp)
	{
		if(x==n || y==m) return 0;
		if(dp[x][y] != null) return dp[x][y];

		if(s1.charAt(x) == s2.charAt(y))
		{
			return dp[x][y] = 1+function(s1,s2,n,m,x+1,y+1,dp);
		}
		else
		{
			return dp[x][y] = Math.max(
					function(s1,s2,n,m,x+1,y,dp),
					function(s1,s2,n,m,x,y+1,dp)
					);
		}
	}
}