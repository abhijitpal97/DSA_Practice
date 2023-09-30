package com.example.amazonpractice;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class StockBuySell1 {
	public int maxProfit(int[] prices) {

		int max = 0;
		int price = 0;
		int prev=Integer.MAX_VALUE;

		for(int i=0;i<prices.length;i++)
		{
			if(prices[i]>prev)
			{
				int curr = prices[i]-prev;
				max = Math.max(curr,max);
			}
			else
			{
				prev = Math.min(prices[i] , prev);
			}
		}

		return max;
	}
}