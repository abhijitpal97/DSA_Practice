package com.example.gspractice;

// https://leetcode.com/problems/container-with-most-water/description/
// leetCode75

public class ContainerMaxWater {
	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length-1;
		int max = Integer.MIN_VALUE;

		while(start<end)
		{
			max = Math.max(max , Math.min(height[start] , height[end]) * (end-start));
			if(height[start]<height[end]) start++;
			else if(height[start]>height[end]) end--;
			else 
			{
				start++;
				end--;
			}
		}

		if(max == Integer.MIN_VALUE) return 0;
		return max;
	}
}