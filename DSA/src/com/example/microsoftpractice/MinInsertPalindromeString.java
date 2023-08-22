package com.example.microsoftpractice;

public class MinInsertPalindromeString {
	public int minInsertions(String s) {
		int len = s.length();
		Integer[][] dp = new Integer[len][len];
		return function(s , 0 , len-1 , dp);
	}

	public int function(String str , int left , int right , Integer[][] dp)
	{
		if(dp[left][right] != null) return dp[left][right];
		if(left == right) return 0;
		if(left +1 == right)
		{
			if(str.charAt(left) == str.charAt(right)) return 0;
			else return 1;
		}
		if(str.charAt(left) == str.charAt(right))
		{
			return dp[left][right] = function(str , left+1 , right-1 , dp);

		}
		else
		{
			return dp[left][right] = 1+ Math.min(
					function(str, left+1,right,dp),
					function(str,left,right-1,dp)
					);

		}
	}
}