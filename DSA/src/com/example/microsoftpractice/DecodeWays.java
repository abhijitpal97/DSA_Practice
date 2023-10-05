package com.example.microsoftpractice;

// https://leetcode.com/problems/decode-ways/description/

public class DecodeWays {
	public int numDecodings(String s) {
		Integer[] dp = new Integer[s.length()];
		return function(s , 0 , dp);
	}

	int function(String str , int index , Integer[] dp)
	{
		if(index>=str.length()) return 1;
		if(str.charAt(index) == '0') return 0;

		if(dp[index] != null) return dp[index];
		int count = function(str , index+1 , dp);

		if(index == str.length()-1) return 1;

		if(Integer.parseInt(str.substring(index , index+2))<=26)
		{
			count += function(str , index+2 , dp);
		}

		return dp[index] = count;
	}
}