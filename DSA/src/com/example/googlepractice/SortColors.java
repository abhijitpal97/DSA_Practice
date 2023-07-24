package com.example.googlepractice;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid<=high)
        {
            if(nums[mid] == 0)
            {
                swap(nums , low , mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1) mid++;
            else if(nums[mid] == 2)
            {
                swap(nums , mid , high);
                high--;
            }
        }
    }

    void swap(int[] nums , int x , int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}