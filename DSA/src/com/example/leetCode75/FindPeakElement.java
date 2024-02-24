package com.example.leetCode75;

// https://leetcode.com/problems/find-peak-element/

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(nums.length == 1) return 0;
		int peakEle=0;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]>nums[i-1]) peakEle=i;
		}

		return peakEle;
	}
}