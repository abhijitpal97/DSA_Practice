package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/

public class MaxNumberKSumPair {
	public int maxOperations(int[] nums, int k) {
		int count = 0;
		int n = nums.length;
		Arrays.sort(nums);

		int start = 0;
		int end = n-1;

		while(start<end)
		{
			int curr = nums[start]+nums[end];
			if(curr == k)
			{
				count++;
				start++;
				end--;
			}
			else if(curr > k) end--;
			else start++;
		}
		return count;

	}
}