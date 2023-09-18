package com.example.amazonpractice;

import java.util.Arrays;

public class MinIncrementToMakeArrayUnique {
	public int minIncrementForUnique(int[] nums) {
		// 1 1 2 2 3 7 
		Arrays.sort(nums);
		return minCalculate(nums);
	}

	int minCalculate(int[] nums)
	{
		int count =0;
		int diff = 0;

		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]<=nums[i-1])
			{
				diff = nums[i-1] - nums[i]+1;
				nums[i] = nums[i]+diff;
				count += diff;
			}
		}

		return count;
	}
}