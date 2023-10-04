package com.example.microsoftpractice;

// https://leetcode.com/problems/coin-change/

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		Integer[][] dp = new Integer[coins.length][amount+1];
		int ans = function(coins , amount , 0, coins.length , dp);
		if(ans >= 1e9) return -1;
		return ans;
	}

	int function(int[] coins , int amount , int index , int n ,  Integer[][] dp)
	{
		if(amount == 0) return 0;
		if(amount < 0) return  (int)1e9;
		if(index>=n) return (int)1e9;
		if(dp[index][amount] != null) return dp[index][amount];

		int pick = 1+function(coins , amount-coins[index] , index , n ,dp);
		int notPick = function(coins , amount , index+1 ,n , dp);

		return dp[index][amount] = Math.min(pick , notPick);

	}
}
