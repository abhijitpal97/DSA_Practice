package com.example.microsoftpractice;

public class IncreasingSubsequence {
	
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length+1][nums.length+1];
        return function(nums,-1,0,dp);
    }

    int function(int[] nums , int prev , int index , Integer[][] dp)
    {
        if(index>=nums.length) return 0;

        if(dp[index][prev+1] != null) return dp[index][prev+1];
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || nums[index]>nums[prev]) pick = 1+function(nums,index,index+1,dp);
        int nonPick = function(nums,prev,index+1,dp);

        return dp[index][prev+1] = Math.max(pick,nonPick);
    }
}