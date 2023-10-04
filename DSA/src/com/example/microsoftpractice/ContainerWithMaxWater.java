package com.example.microsoftpractice;

// https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMaxWater {
	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length-1;
		int max = 0;
		while(start<end)
		{
			int min = Math.min(height[start],height[end]);
			max = Math.max(max , min*(end-start));

			if(height[start] == height[end])
			{
				start++;
				end--;
			}
			else if(height[start] > height[end]) end--;
			else start++;
		}

		return max;
	}
}