package com.example.uncategorized;

// https://leetcode.com/problems/minimum-number-of-coins-for-fruits/description/

public class MinCoinsForFruits {
	public int minimumCoins(int[] prices) {
		int n = prices.length;
		Integer[][] dp = new Integer[n][n+1];
		return function(0 , 0 , prices , dp);
	}

	public int function(int i,int free,int prices[],Integer dp[][]){
		if(i>=prices.length)
			return 0;
		if(dp[i][free]!=null)
			return dp[i][free];
		int take = function(i+1,i+1,prices,dp)+prices[i];
		int nottake = Integer.MAX_VALUE;
		if(free>0){
			nottake  = function(i+1,free-1,prices,dp);
		}
		return dp[i][free] = Math.min(take,nottake);
	}
}