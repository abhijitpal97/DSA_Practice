package com.example.gspractice;

public class MinSubArraySumTarget {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int curr = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            curr +=nums[i];
            if(curr>=target)
            {
                res = Math.min(res , i - start+1);
                while(curr>=target)
                {
                    curr -= nums[start];
                    start++;
                    if(curr>=target) res = Math.min(res , i - start+1);
                }
            }
        }

        return res == Integer.MAX_VALUE?0:res;
    }
}