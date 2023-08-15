package com.example.amazonpractice;

import java.util.Arrays;

public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
       Arrays.sort(nums);
        int temp[] = new int[nums.length];
        int k = nums.length-1;
        for(int i=1;i<nums.length;i+=2)temp[i] = nums[k--];
        for(int i=0;i<nums.length;i+=2)temp[i] = nums[k--];
        for(int i=0;i<nums.length;i++)nums[i]=temp[i]; 
    }
}