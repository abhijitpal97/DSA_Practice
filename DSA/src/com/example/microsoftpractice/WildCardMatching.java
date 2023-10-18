package com.example.microsoftpractice;

// https://leetcode.com/problems/wildcard-matching/description/

public class WildCardMatching {
	public boolean isMatch(String s, String p) {
		Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
		return function(s,p,0,0,dp);
	}

	boolean function(String s , String p , int i , int j , Boolean[][] dp)
	{
		if(i>=s.length() && j>=p.length()) return true;
		if(j>=p.length()) return false;
		if(dp[i][j] != null) return dp[i][j];

		boolean charMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

		if(j+1<p.length() && p.charAt(j+1) == '*')
		{
			dp[i][j] = function(s,p,i,j+2,dp) || charMatch && function(s,p,i+1,j,dp);
		} 
		else if(charMatch)
		{
			dp[i][j] = function(s,p,i+1,j+1,dp);
		}
		else dp[i][j] = false;

		return dp[i][j];
	}

	// Varient 

	public boolean isMatchV(String s, String p) {
		Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
		return functionV(s,p,0,0,dp);
	}

	boolean functionV(String s , String p , int i , int j , Boolean[][] dp)
	{
		if(i>=s.length() && j>=p.length()) return true;
		if(j>=p.length()) return false;
		if(dp[i][j] != null) return dp[i][j];

		boolean charMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');

		if(p.charAt(j) == '*')
		{
			dp[i][j] = function(s,p,i,j+1,dp) || i<s.length() && function(s,p,i+1,j,dp);
		} 
		else if(charMatch)
		{
			dp[i][j] = function(s,p,i+1,j+1,dp);
		}
		else dp[i][j] = false;

		return dp[i][j];
	}
}