package com.example.gspractice;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[n-1] = 0;

        for(int i = n-2 ; i>=0 ; i--)
        {
            int min = Integer.MAX_VALUE;
            for(int j =i+1 ; j<=Math.min(n-1 , i+nums[i]) ; j++)
            {
                min = Math.min(dp[j] , min);
            }
            if(min != Integer.MAX_VALUE) dp[i] = 1+min;
        }
        if(dp[0] == Integer.MAX_VALUE) return -1;
        return dp[0];
    }
}