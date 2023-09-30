package com.example.olapractice;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

public class BuySellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = stockBuyAndSell(7, new int[] {100 ,180, 260, 310, 40, 535, 695});
		System.out.println(res);

	}

	public static int stockBuyAndSell(int n, int[] prices) {
		// code here

		int profit = 0;
		int curr = prices[0];
		int profitTillNow = 0;

		for(int i=1;i<n;i++)
		{
			if(prices[i]>curr)
			{
				profitTillNow += prices[i] - curr;
				curr = prices[i];
			}
			else
			{
				profit += profitTillNow;
				profitTillNow = 0;
				curr = prices[i];
			}
		}
		profit += profitTillNow;
		return profit;
	}



}
