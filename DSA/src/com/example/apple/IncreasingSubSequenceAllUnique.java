package com.example.apple;

import java.util.*;

public class IncreasingSubSequenceAllUnique {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		function(0,nums.length,nums,new ArrayList<>(),result,Integer.MIN_VALUE);
		return result;
	}

	void function(int index , int n , int[] nums , List<Integer> list , List<List<Integer>> result , int prev)
	{
		if(list.size()>=2)
		{
			if(! result.contains(list))result.add(new ArrayList<>(list));
		}

		if(index>=n) return;

		if(prev == Integer.MIN_VALUE || nums[index]>=prev)
		{
			list.add(nums[index]);
			function(index+1,n,nums,list,result,nums[index]);
			list.remove(list.size()-1);
		}
		function(index+1,n,nums,list,result,prev);
	}
}