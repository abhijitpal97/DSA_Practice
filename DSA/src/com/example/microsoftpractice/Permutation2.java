package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/permutations-ii/

public class Permutation2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		int n = nums.length;
		int[] freq = new int[n];
		List<List<Integer>> list = new ArrayList<>();
		function(nums , n , freq , list , new ArrayList<>());
		return list;
	}

	void function(int[] nums , int length , int[] freq , List<List<Integer>> result , List<Integer> list)
	{
		if(list.size() == length)
		{
			if(! result.contains(list)) result.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<length;i++)
		{
			if(freq[i] == 0)
			{
				freq[i] = 1;
				list.add(nums[i]);
				function(nums , length,freq,result,list);
				freq[i] = 0;
				list.remove(list.size()-1);
			}
		}
	}
}