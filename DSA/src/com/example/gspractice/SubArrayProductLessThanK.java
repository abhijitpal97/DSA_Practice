package com.example.gspractice;

public class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        
        int product = 1;
        int start = 0;
        int end = 0;
        int max = 0;
        while(end<nums.length)
        {
            product *= nums[end];
            while(product >= k)
                {
                    product = product/nums[start];
                    start++;
                }
                max = max+end-start+1;
                end++;
        }

        return max;
    }
}
