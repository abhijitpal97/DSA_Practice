package com.example.microsoftpractice;

// https://leetcode.com/problems/sort-colors/

public class SortZeroOneTwos {
	public void sortColors(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid = 0 ;

		while(mid<=high)
		{
			if(nums[mid] == 0)
			{
				swap(nums,low , mid);
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

	void swap(int[] nums , int a , int b)
	{
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}