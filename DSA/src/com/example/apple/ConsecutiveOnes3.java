package com.example.apple;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class ConsecutiveOnes3 {
	public int longestOnes(int[] nums, int k) {
		int start = 0;
		int end = 0;
		int zero = 0;
		int n = nums.length;
		int longest = 0;
		while(end < n)
		{
			if(nums[end] == 0) zero++;

			while(zero>k)
			{
				if(nums[start] == 0) zero --;
				start++;
			}

			longest = Math.max(longest , end-start+1);

			end++;
		}

		return longest;
	}
}