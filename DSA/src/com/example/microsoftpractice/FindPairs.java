package com.example.microsoftpractice;

import java.util.*;

public class FindPairs {
	public int findPairs(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i<nums.length;i++)
		{
			if(set.contains(nums[i]+k))
			{
				List<Integer> res = new ArrayList<>(new ArrayList<>(Arrays.asList(nums[i] , nums[i]+k)));
				if(!list.contains(res)) list.add(res);
			}
			if(set.contains(nums[i]-k))
			{
				List<Integer> res = new ArrayList<>(new ArrayList<>(Arrays.asList(nums[i]-k , nums[i])));
				if(!list.contains(res)) list.add(res);
			}
			set.add(nums[i]);
		}

		return list.size();
	}
}