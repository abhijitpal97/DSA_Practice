package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/combination-sum-ii/

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		function(candidates , 0 ,target, new ArrayList<>() , result);

		return result;
	}

	void function(int[] candidates , int index , int target , List<Integer> list , List<List<Integer>> result)
	{
		if(target==0)
		{
			if(! result.contains(list))result.add(new ArrayList<>(list));
			return;
		}
		if(target<0) return ;
		if(index>=candidates.length) return;

		list.add(candidates[index]);
		function(candidates , index+1 , target-candidates[index] , list ,result);
		list.remove(list.size()-1);
		function(candidates , index+1 , target , list , result);
	}
}