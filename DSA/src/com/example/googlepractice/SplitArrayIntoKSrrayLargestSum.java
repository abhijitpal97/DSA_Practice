package com.example.googlepractice;

// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayIntoKSrrayLargestSum {
	public int splitArray(int[] nums, int k) {
		int min = getMin(nums);
		int max = getMax(nums);
		while(min<=max)
		{
			int mid = min + (max-min)/2;
			if(isPossible(nums , k , mid))
			{
				max = mid-1;
			}
			else min=mid+1;
		}

		return min;
	}

	int getMin(int[] nums)
	{
		int min = Integer.MIN_VALUE;
		for(int i=0 ; i<nums.length ; i++) min = Math.max(min , nums[i]);

		return min;
	}

	int getMax(int[] nums)
	{
		int max = 0;
		for(int i = 0 ; i<nums.length ; i++) max += nums[i];
		return max;
	}

	boolean isPossible(int[] nums , int k , int max)
	{
		int currSum = 0;
		int count=1;
		for(int i = 0 ; i<nums.length;i++)
		{
			currSum += nums[i];
			if(currSum>max)
			{
				count++;
				currSum = nums[i];
			}
		}

		return count<=k;
	}

}