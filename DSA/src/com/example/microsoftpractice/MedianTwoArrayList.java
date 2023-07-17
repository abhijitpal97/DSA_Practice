package com.example.microsoftpractice;

public class MedianTwoArrayList {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while(i<n1 && j<n2)
        {
            if(nums1[i]<=nums2[j]){
                nums[k] = nums1[i];
                i++;
            } 
            else
            {
                nums[k] = nums2[j];
                j++;
            }

            k++;
        }

        while(i<n1)
        {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j<n2)
        {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        if(nums.length %2 == 1) return nums[nums.length/2];
        else
        {
            //System.out.println(nums[(nums.length/2)-1]);
            //System.out.println(nums[(nums.length/2)]);
            return  (nums[nums.length/2] + nums[(nums.length/2)-1]) / 2.0 ;
        }
    }
}