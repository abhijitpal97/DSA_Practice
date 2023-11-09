package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/description/

public class MaxNonOverLappingTargetSum {
	public int maxNonOverlapping(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		int currSum  =0;
		int count = 0;
		set.add(0);
		for(int i=0;i<nums.length; i++)
		{
			currSum += nums[i];
			if(set.contains(currSum-target))
			{
				count += 1;
				currSum = 0;
				set.removeAll(set);
				set.add(0);
			}
			else
			{
				set.add(currSum);
			}
		}

		return count;
	}
}