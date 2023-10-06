package com.example.microsoftpractice;

// https://leetcode.com/problems/maximum-product-subarray/description/

public class MaxProductSubArray {
	public int maxProduct(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		int prod = nums[0];;

		for(int i=1 ; i<nums.length; i++)
		{
			int lMin = min ; 
			int lMax = max ; 

			if(nums[i]<0)
			{
				min = Math.min(lMax*nums[i] , nums[i]);
				max = Math.max(lMin*nums[i] , nums[i]);
			}
			else
			{
				max = Math.max(lMax*nums[i] , nums[i]);
				min = Math.min(lMin*nums[i] , nums[i]);
			}

			prod = Math.max(prod , max);
		}

		return prod; 
	}
}