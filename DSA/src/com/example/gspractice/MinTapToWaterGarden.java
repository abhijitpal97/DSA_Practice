package com.example.gspractice;

// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

public class MinTapToWaterGarden {
	public int minTaps(int n, int[] ranges) {
		int min = 0;
		int max = 0;
		int taps = 0;

		while(max<n)
		{
			for(int i =0 ; i<ranges.length;i++)
			{
				if(i-ranges[i]<=min && i+ranges[i]>max)
				{
					max = i+ranges[i];
				}
			}

			if(max==min) return -1;

			taps++;

			min = max;
		}

		return taps;
	}
}