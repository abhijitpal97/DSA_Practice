package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/subarray-sum-equals-k/description/

public class SubArraySumK {
	public int subarraySum(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0 , 1);
		int curr = 0;
		int count = 0;
		for(int i = 0 ; i< nums.length; i++)
		{
			curr += nums[i];

			if(map.containsKey(curr - k))
			{
				count += map.get(curr-k);
			}

			map.put(curr , map.getOrDefault(curr , 0)+1);
		}

		return count;
	}
}