package com.example.ciscopractice;

import java.util.Arrays;

// https://leetcode.com/problems/decode-ways/description/

public class DecodeWays {
	public int numDecodings(String s) {
		int[] dp = new int[s.length()+1];
		Arrays.fill(dp,-1);
		return helper(s, 0 , dp);
	}

	int helper(String s , int index , int[] dp)
	{
		if(index>= s.length()) return 1;
		if(s.charAt(index) == '0') return 0;

		if(dp[index] != -1) return dp[index];

		int count = helper(s , index+1 , dp);

		if(index== s.length()-1) return 1;
		if(Integer.parseInt(s.substring(index , index+2)) <=26) count+=helper(s , index+2 , dp);


		return dp[index] = count;
	}
}