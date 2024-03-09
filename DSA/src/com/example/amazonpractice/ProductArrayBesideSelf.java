package com.example.amazonpractice;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/description/
// leetCode75

public class ProductArrayBesideSelf {
	public int[] productExceptSelf(int[] nums) {
		int prod = 1;
		int zero = 0;
		for(int i : nums)
		{
			if(i == 0) zero++;
			else
			{
				prod *= i;
			}
		}

		int[] res = new int[nums.length];
		if(zero>1)
		{
			Arrays.fill(res , 0);
			return res;
		}
		if(zero == 1)
		{
			for(int i=0;i<nums.length;i++)
			{
				if(nums[i] == 0) res[i] = prod;
				else res[i] = 0;
			}

			return res;
		}

		for(int i=0;i<nums.length;i++)
		{
			res[i] = prod/nums[i];
		}
		return res;

	}
}