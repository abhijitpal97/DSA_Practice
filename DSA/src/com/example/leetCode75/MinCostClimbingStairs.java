package com.example.leetCode75;

// https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		Integer[] dp = new Integer[n];

		return Math.min(
				function(0 , n , cost , dp),
				function(1 , n , cost , dp)
				);
	}

	int function(int index , int n , int[] cost , Integer[] dp)
	{
		if(index >= n) return 0;
		if(dp[index] != null) return dp[index];

		int sJ = function(index+1 , n , cost , dp)+cost[index];
		int dJ = function(index+2 , n , cost , dp)+cost[index];

		return dp[index] = Math.min(sJ , dJ);
	}
}