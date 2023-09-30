package com.example.microsoftpractice;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

public class BuySellStock3 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) 
			return 0;

		int n = prices.length;
		int profit = 0;

		int[] left = new int[n];
		int min = prices[0];

		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}


		int[] right = new int[n];
		int max = prices[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}

		for(int i=0;i<n;i++)
		{
			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}
}