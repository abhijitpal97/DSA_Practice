package com.example.amazonpractice;
// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays

public class WaysToSplit {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;
        
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1;i<n;i++) preSum[i] += preSum[i-1]+nums[i];

        int total = preSum[n-1];
        int ways = 0;
        int i=0;
        int j=0;
        int k=0;

        for(; i<n-2 && 3*preSum[i] <= total ; i++)
        {
            j = Math.max(j , i+1);
            while(j <n-1 && preSum[j]-preSum[i] <preSum[i]) j++;

            k = Math.max(k , j);
            while(k<n-1 && preSum[k]-preSum[i] <= total-preSum[k]) k++;

            ways += (k-j)%MOD;
            ways %= MOD;
        }

        return ways;
    }
}