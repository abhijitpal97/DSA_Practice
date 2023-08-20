package com.example.microsoftpractice;

public class WaterBottles {
	int count  = 0;
	public int numWaterBottles(int numBottles, int numExchange) {
		count = 0;
		helper(numBottles , Integer.MIN_VALUE , numExchange);
		return count;
	}
	void helper(int full ,int empty , int exchange)
	{
		//System.out.println(full + " - "+empty);
		if(empty != Integer.MIN_VALUE && full+empty<exchange)
		{
			count +=full;
			return;
		} 
		if(empty == Integer.MIN_VALUE) empty = 0;
		count +=full; //15+3+1
		empty +=full; //15 6 3
		int exchangePossible = empty/exchange; //3 1 0
		empty -= (exchangePossible*exchange); // 3 2 3

		helper(exchangePossible , empty , exchange);
	}
}