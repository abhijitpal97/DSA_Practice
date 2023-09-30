package com.example.apple;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

public class MaxProfitBuyAndSellStock4 {
	public int maxProfit(int k, int[] prices) {
		Integer[][][] dp = new Integer[prices.length][k][2];
		return function(prices , k , 0 , 1 , dp , 0);        
	}

	int function(int[] prices , int k , int index , int hold , Integer[][][] dp , int capacity)
	{
		if(index >= prices.length || capacity == k) return 0 ;
		if(dp[index][capacity][hold] != null) return dp[index][capacity][hold];

		int profit = 0;
		if(hold == 1) 
		{
			profit = Math.max(
					function(prices , k , index+1 , 0 , dp , capacity)-prices[index],
					function(prices , k , index+1 , 1 , dp , capacity));
		}
		else
		{
			profit = Math.max(
					prices[index]+function(prices , k , index+1 , 1 , dp , capacity+1),
					function(prices , k , index+1 , 0 , dp , capacity));
		}

		return dp[index][capacity][hold] = profit;
	}
}