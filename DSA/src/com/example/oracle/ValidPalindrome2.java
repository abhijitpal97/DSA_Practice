package com.example.oracle;

// https://leetcode.com/problems/valid-palindrome-ii/description/

public class ValidPalindrome2 {
	public boolean validPalindrome(String s) {
		int n = s.length();
		Boolean[][] dp = new Boolean[n+1][n+1];
		return function(s,0,n-1,n, dp,1);
	}

	boolean function(String s , int start , int end , int n, Boolean[][] dp , int k)
	{
		if(k<0) return false;
		if(start >= end) return true;
		if(dp[start][end] != null) return dp[start][end];
		if(s.charAt(start) == s.charAt(end))
		{
			return dp[start][end] = function(s,start+1,end-1,n,dp,k);
		}
		else
		{
			return dp[start][end] = function(s,start+1,end,n,dp,k-1) ||
					function(s,start,end-1,n,dp,k-1);
		}
	}

	// Recursion

	public boolean validPalindromeRec(String s) {
		return functionRec(s,0,s.length()-1,false);
	}

	boolean functionRec(String s , int start , int end , boolean used)
	{
		if(start >= end) return true;
		if(s.charAt(start) != s.charAt(end))
		{
			if(! used)
			{
				if(functionRec(s,start+1,end,true)) return true;
				return functionRec(s,start,end-1,true);
			}
			else return false;
		}
		return functionRec(s,start+1,end-1,used);
	}
}