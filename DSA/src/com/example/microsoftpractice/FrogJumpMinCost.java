package com.example.microsoftpractice;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/frog-jump_3621012

public class FrogJumpMinCost {
	public static int frogJump(int n, int heights[]) {

		// Write your code here..
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		return function(0 , dp , heights , n);

	}

	static int function(int curr , int[] dp , int[] heights , int n)
	{
		if(curr == n-1) return 0;
		if(dp[curr] != -1) return dp[curr];

		int doubleJ = Integer.MAX_VALUE;
		int singleJ = Integer.MAX_VALUE;
		if(curr+1 < n)singleJ = Math.abs(heights[curr+1] - heights[curr])+function(curr+1,dp , heights, n);

		if(curr+2<n) doubleJ = Math.abs(heights[curr+2] - heights[curr])+function(curr+2,dp , heights , n);

		return dp[curr] = Math.min(singleJ ,doubleJ);
	}
}