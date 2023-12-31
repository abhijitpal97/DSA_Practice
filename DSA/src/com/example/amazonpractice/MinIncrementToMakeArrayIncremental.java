package com.example.amazonpractice;

// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/description/

public class MinIncrementToMakeArrayIncremental {
	public int minOperations(int[] nums) {
		if(nums.length <=1) return 0;
		int curr = nums[0];
		int count = 0 ;
		for(int i = 1 ; i<nums.length ; i++)
		{
			if(nums[i] > curr)
			{
				curr = nums[i];
				continue;
			}
			else
			{
				count += curr-nums[i]+1;
				curr = nums[i]+(curr-nums[i]+1);
			}
		}

		return count;
	}
}