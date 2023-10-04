package com.example.microsoftpractice;

// https://leetcode.com/problems/coin-change-ii/

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		Integer[][] dp = new Integer[coins.length+1][amount+1];
		return function(coins.length , 0 , coins , amount , dp);
	}

	int function(int n , int index , int[] coins , int amount , Integer[][] dp)
	{
		if(amount == 0) return 1;
		if(amount<0) return 0;
		if(index==n) return 0;
		if(dp[index][amount] != null) return dp[index][amount];
		int pick = function(n , index , coins , amount-coins[index] , dp);
		int notPick = function(n , index+1 , coins , amount, dp);

		return dp[index][amount] = pick+notPick;
	}
}