package com.example.apple;

import java.util.*;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

public class CountSmallerAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int n = nums.length;

		for(int i=n-1;i>=0;i--)
		{
			int count = 0;
			int curr = nums[i];
			for(int j = i+1 ; j<n ; j++)
			{
				if(curr>nums[j]) count++;
			}
			list.add(0 , count);
		}

		return list;
	}
}