package com.example.uncategorized;

// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

public class MaxLengthSubarrayWithPositiveProduct {
	public int getMaxLen(int[] nums) {
		int pos = 0;
		int neg = 0;
		int res = 0;
		int n = nums.length;

		for(int i=0;i<n;i++)
		{
			if(nums[i] == 0)
			{
				pos = 0;
				neg = 0;
			}
			else if(nums[i] >0)
			{
				pos +=1;
				neg = neg==0?0:neg+1;
			}
			else
			{
				int temp = pos;
				pos = neg == 0?0 : neg+1;
				neg = temp+1;
			}

			res = Math.max(res , pos);
		}

		return res;
	}
}