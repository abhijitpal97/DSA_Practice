package com.example.gspractice;

public class NextGreaterPermutation {
	public void nextPermutation(int[] nums) {
		int idx = -1;
		int n = nums.length;

		for(int i = n-2;i>=0;i--)
		{
			if(nums[i]<nums[i+1])
			{
				idx = i;
				break;
			}
		}

		if(idx == -1) reverse(nums , 0 ,nums.length-1);
		else
		{
			for(int i=n-1;i>idx;i--)
			{
				if(nums[i]>nums[idx])
				{
					swap(nums , i , idx);
					break;
				}
			}

			reverse(nums , idx+1 , nums.length-1);
		}
	}

	void reverse(int[] nums,int start , int end)
	{
		while(start<end)
		{
			swap(nums , start , end);
			start++;
			end--;
		}
	}

	void swap(int[] nums , int start , int end)
	{
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
}