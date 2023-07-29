package com.example.microsoftpractice;

public class PartionSum {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        int rows = nums.length;
        for(int i : nums) sum +=i;
        if(sum%2 == 1) return false;
        Boolean[][] dp = new Boolean[rows][sum+1];

        return function(nums , dp , 0 , sum/2 , rows);
    }

    boolean function(int[] nums , Boolean[][] dp , int index , int target , int rows)
    {
        if(target == 0) return true;
        if(target<0 || index>=rows) return false;
        
        if(dp[index][target] != null) return dp[index][target];
        boolean pick = function(nums , dp , index+1 , target-nums[index] , rows);
        boolean notPick = function(nums , dp , index+1 , target , rows);

        return dp[index][target] = pick || notPick ;
    }
}