package com.example.amazonpractice;

public class MaxScoreWithMultiplyOperation {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        Integer[][] dp = new Integer[n][m];
        return function(nums , multipliers , 0 , n-1 , 0 , dp);
    }

    int function(int[] nums , int[] muls , int start , int end , int index , Integer[][] dp)
    {
        if(index>=muls.length) return 0 ;
        if(dp[start][index] != null) return dp[start][index];
        int first =( muls[index]*nums[start] ) + function(nums , muls , start+1 ,end , index+1,dp);
        int last = ( muls[index]*nums[end] ) + function(nums , muls , start ,end-1 , index+1,dp);

        dp[start][index]= Math.max(first,last);
        return dp[start][index];
    }
}