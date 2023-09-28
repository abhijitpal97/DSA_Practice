package com.example.amazonpractice;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

public class MinCapacityShipWithInDays {
	public int shipWithinDays(int[] weights, int days) {
		int min = getMin(weights);
		int max = getMax(weights);

		while(min <= max)
		{
			int mid = min + (max - min)/2;
			if(checkMin(weights , days , mid))
			{
				max = mid-1;
			}
			else min = mid+1;
		}
		return min;
	}

	int getMin(int[] weights)
	{
		int wt = weights[0];

		for(int wth:weights)
		{
			if(wth>wt) wt = wth;

		}
		return wt;
	}

	int getMax(int[] weights)
	{
		int wt = 0;

		for(int wth:weights)
		{
			wt += wth;

		}
		return wt;
	}

	boolean checkMin(int[] weights , int days , int max)
	{
		int curr = 0;
		int currD = 1;
		for(int i = 0 ; i<weights.length;i++)
		{
			curr +=weights[i];
			if(curr>max)
			{
				currD++;
				curr = weights[i];
			}
		}

		return currD<=days;
	}
}