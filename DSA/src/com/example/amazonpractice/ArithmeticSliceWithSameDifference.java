package com.example.amazonpractice;

// https://leetcode.com/problems/arithmetic-slices/

public class ArithmeticSliceWithSameDifference {
	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		Integer[][] dp = new Integer[n][n];
		int res = 0;
		for(int i=1;i<=n-1 ; i++)
		{
			res += function(nums, nums[i]-nums[i-1] , 1 , i , dp,n);
		}

		return res;
	}

	int function(int[] nums, int diff , int size , int index , Integer[][] dp, int n)
	{
		int ans = 0;
		if(size >= 3)
		{
			ans = 1;
		}
		if(index>=n) return ans;
		if(dp[index-1][size] != null) return dp[index-1][size];
		if((nums[index] - nums[index-1]) == diff)
		{
			ans += function(nums , diff , size+1 , index+1 , dp , n);
		}

		return dp[index-1][size] = ans;

	}
}