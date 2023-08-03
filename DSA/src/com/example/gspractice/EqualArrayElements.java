package com.example.gspractice;

import java.util.Arrays;

public class EqualArrayElements {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            count +=nums[i]-nums[0];
        }
        return count;
    }
}