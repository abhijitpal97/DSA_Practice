package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/

public class LongestSubArraywithLimitAbsoluteDifference {
	public int longestSubarray(int[] nums, int limit) {
		Queue<Integer> min = new PriorityQueue<Integer>();
		Queue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());

		int start = 0;
		int end = 0;
		int n = nums.length;
		int res = 0;
		while(end<n)
		{
			min.add(nums[end]);
			max.add(nums[end]);

			while(!min.isEmpty() && Math.abs(max.peek()-min.peek())>limit)
			{
				min.remove(nums[start]);
				max.remove(nums[start]);
				start++;
			}

			res = Math.max(end-start+1 , res);
			end++;
		}

		return res;
	}
}