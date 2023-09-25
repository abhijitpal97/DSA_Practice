package com.example.gspractice;

// https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
	public int trap(int[] height) {
		int n = height.length;
		if(n == 1) return 0;
		int[] left = new int[n];
		left[0] = height[0];
		for(int i=1;i<n;i++)
		{
			left[i] = Math.max(left[i-1] , height[i]);
		}

		int[] right = new int[n];
		right[n-1] = height[n-1];

		for(int i = n-2;i>=0;i--)
		{
			right[i] = Math.max(right[i+1] , height[i]);
		}

		int rainWater = 0;

		for(int i=0;i<n;i++)
		{
			rainWater = rainWater+(Math.min(left[i] , right[i]) -height[i]);
		}

		return rainWater;
	}
}