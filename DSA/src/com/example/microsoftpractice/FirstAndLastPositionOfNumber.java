package com.example.microsoftpractice;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FirstAndLastPositionOfNumber {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findFirst(nums , target);
		result[1] = findLast(nums , target);

		return result;
	}

	int findFirst(int[] nums , int target)
	{
		int start = 0;
		int end = nums.length-1;
		int index = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2 ;

			if(nums[mid]>=target) end = mid-1;
			else start = mid+1;

			if(nums[mid] == target) index = mid;
		}

		return index;
	}

	int findLast(int[] nums , int target)
	{
		int start = 0;
		int end = nums.length-1;
		int index = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2 ;

			if(nums[mid]<=target) start = mid+1;
			else end = mid-1;

			if(nums[mid] == target)  index = mid;
		}

		return index;
	}
}