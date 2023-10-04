package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/combination-sum/

public class CombinationSum1 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		function(candidates, 0 , target , new ArrayList<>() , result);
		return result;
	}

	void function(int[] candidates , int index , int target , List<Integer> list , List<List<Integer>> result)
	{
		if(target==0)
		{
			result.add(new ArrayList<>(list));
			return;
		}
		if(target<0) return ;
		if(index>=candidates.length) return;

		list.add(candidates[index]);
		function(candidates , index , target-candidates[index] , list ,result);
		list.remove(list.size()-1);
		function(candidates , index+1 , target , list , result);
	}
}