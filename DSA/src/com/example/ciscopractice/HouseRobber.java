package com.example.ciscopractice;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return function(nums , dp , 0);
    }

    int function(int[] nums , int[] dp , int index)
    {
        if(index>=nums.length) return 0;

        if(dp[index] != -1) return dp[index];
        int pick = nums[index]+function(nums , dp ,index+2);
        int notPick = function(nums , dp , index+1);

        return dp[index] = Math.max(pick , notPick);
    }
}