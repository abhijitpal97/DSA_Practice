package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/capacity-to-ship-packages-within-d-days_1229379

public class ShipCapacityWeight {
	public static int leastWeightCapacity(int[] weights, int d) {
		// Write your code here.
		int min = Integer.MIN_VALUE;
		int max = 0;
		int n = weights.length;

		for(int i=0;i<n;i++)
		{
			min = Math.max(min , weights[i]);
			max += weights[i];
		}

		while(min<max)
		{
			int mid = (max+min)/2;

			if(isPossible(weights , d , mid))
			{
				max = mid-1;
			}
			else min = mid+1;
		}

		return min;
	}

	static boolean isPossible(int[] weights , int d , int mid)
	{
		int curr = 0;
		int count = 1;

		for(int i= 0 ;i<weights.length; i++)
		{
			curr += weights[i];
			if(curr>mid)
			{
				count++;
				curr = weights[i];
			}
		}

		return count<=d;
	}
}