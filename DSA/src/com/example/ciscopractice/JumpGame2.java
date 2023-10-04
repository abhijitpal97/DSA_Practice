package com.example.ciscopractice;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game-ii/description/
public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[n-1] = 0;

        for(int i = n-2; i>=0;i--)
        {
            int min = Integer.MAX_VALUE;

            for(int j=i+1; j<=Math.min(i+nums[i] , n-1) ; j++)
            {
                min = Math.min(min , dp[j]);
            }
            if(min != Integer.MAX_VALUE) dp[i] = 1+min;
        }

        if(dp[0] == Integer.MAX_VALUE) return -1;
        return dp[0];
    }
}