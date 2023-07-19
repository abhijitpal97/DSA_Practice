package com.example.ciscopractice;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high)
        {
           int mid = low + ((high - low)/2);
            
            if(nums[mid] == target)
                return mid;
            else if (nums[mid]>target)
            {
                if(nums[low] <= nums[mid] && nums[low] > target)
                    low = mid+1;
                else
                    high = mid-1;
            }
            else
            {
                if(nums[high] >= nums[mid] && nums[high] <target)
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        
        return -1;
    }
}