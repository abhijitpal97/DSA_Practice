package com.example.microsoftpractice;

public class MaxDistanceToClosestPerson {
	public int maxDistToClosest(int[] seats) {
		int n = seats.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i<n ;i++)
		{
			if(seats[i] == 1) continue;
			int lStart = i;
			int rStart = i;
			if(i==0)
			{
				while(rStart<n && seats[rStart] == 0) rStart++;
				int rDistance = rStart-i;
				max = Math.max(max , rDistance);
			}
			if(i == n-1)
			{
				while(lStart>=0 && seats[lStart] == 0) lStart--;
				int lDistance = i-lStart;
				max = Math.max(max , lDistance);
			}
			else
			{
				while(lStart>=0 && seats[lStart] == 0) lStart--;
				while(rStart<n && seats[rStart] == 0) rStart++;
				int lDistance = i-lStart;
				int rDistance = rStart-i;
				int min = Math.min(lDistance , rDistance);
				max = Math.max(max , min);
			}
		}
		return max;
	}
}