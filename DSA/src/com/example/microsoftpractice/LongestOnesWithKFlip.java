package com.example.microsoftpractice;

public class LongestOnesWithKFlip {
	public int longestOnes(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int len = 0;
		int zero = 0;

		while(right<nums.length)
		{
			if(nums[right] == 0) zero++;
			while(zero>k)
			{
				if(nums[left] == 0) zero--;
				left++;
			}

			len = Math.max(len , right-left+1);
			right++;
		}

		return len;
	}
}