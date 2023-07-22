package com.example.googlepractice;

public class MinSubArrayTarget {
    public int minSubArrayLen(int target, int[] nums) {
        int count =Integer.MAX_VALUE;
        int start = 0 ;
        int end = 0;
        
        int sum = 0;
        while(end<nums.length)
        {
            sum += nums[end];
            if(sum>=target)
            {
                count = Math.min(count , end-start+1);

                while(sum>=target)
                {
                    sum -= nums[start];
                    start++;
                    if(sum>=target) count = Math.min(count , end-start+1);
                }
            }
            end++;
        }

        if(count == Integer.MAX_VALUE) return  0;
        return count;
    }
}