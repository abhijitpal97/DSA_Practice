package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/combination-sum-iii/

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		function(new ArrayList<>() , result , 1 , n , k);
		return result;
	}

	void function(List<Integer> list , List<List<Integer>> result , int curr , int target,int k )
	{
		if(list.size()>k) return;
		if(target == 0 && list.size()<k) return;

		if(target == 0 && list.size()==k)
		{
			result.add(new ArrayList<>(list));
			return;
		}
		if(target<0) return;
		if(curr>9) return;

		list.add(curr);
		function(list , result , curr+1 , target-curr,k);
		list.remove(list.size()-1);
		function(list , result , curr+1 , target,k);
	}
}