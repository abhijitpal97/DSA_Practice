package com.example.amazonpractice;

//https://leetcode.com/problems/wiggle-subsequence/description/

public class LongestWiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {

		int n = nums.length;
		if(n == 1){
			return 1;
		}
		Integer[][] dp = new Integer[n][2];

		return Math.max(function(nums,0,true,dp) , function(nums,0,false,dp));
	}

	int function(int[] nums , int index , boolean flag , Integer[][] dp)
	{
		if(index == nums.length - 1) return 1;

		if(flag)
		{
			if(dp[index][1] != null) return dp[index][1];
		}
		else
		{
			if(dp[index][0] != null) return dp[index][0];
		}

		int ans = 0;

		if(flag)
		{
			if(nums[index]<nums[index+1]) ans = Math.max(ans , 1+function(nums , index+1 , false , dp));
			else ans = Math.max(ans , function(nums,index+1,true,dp));
		}
		else
		{
			if(nums[index]>nums[index+1]) ans = Math.max(ans , 1+function(nums , index+1 , true , dp));
			else ans = Math.max(ans , function(nums,index+1,false,dp));
		}

		if(flag) return dp[index][1] = ans;
		return dp[index][0] = ans;

	}
}