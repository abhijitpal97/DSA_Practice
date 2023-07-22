package com.example.ciscopractice;

public class MaxDifference {
    public int maximumDifference(int[] nums) {
        if(nums.length <2) return -1;

        int max = -1;
        int curr = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            if(curr>nums[i])max = Math.max(max , curr - nums[i]);
            else curr = nums[i];
        }

        return max;
    }
}