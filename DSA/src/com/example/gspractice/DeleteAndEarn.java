package com.example.gspractice;

import java.util.*;

// https://leetcode.com/problems/delete-and-earn/

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		int maxVal = 0 ;
		for(int i : nums) 
		{
			map.put(i , map.getOrDefault(i , 0)+i);
			maxVal = Math.max(maxVal , i);
		}
		int[] dp = new int[maxVal+1];

		return function(1,dp , map, maxVal);
	}

	int function(int curr , int[] dp , Map<Integer,Integer> map,int maxval)
	{
		if(curr>maxval) return 0;
		if(dp[curr] != 0) return dp[curr];

		int pick = map.getOrDefault(curr , 0)+function(curr+2,dp , map , maxval);
		int notPick  = function(curr+1 , dp , map,maxval);

		return dp[curr] = Math.max(pick , notPick);

	}
}