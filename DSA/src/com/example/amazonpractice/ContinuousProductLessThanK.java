package com.example.amazonpractice;

// https://leetcode.com/problems/subarray-product-less-than-k/description/

public class ContinuousProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if(k<=1) return 0;

		int prod = 1;
		int start = 0;
		int end = 0;
		int n = nums.length;

		int res = 0;

		while(end<n)
		{
			prod *= nums[end];

			while( prod >=k)
			{
				prod /= nums[start];
				start++;
			}

			res += end -start+1;
			end++;
		}

		return res;
	}
}