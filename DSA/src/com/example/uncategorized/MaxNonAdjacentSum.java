package com.example.uncategorized;
import java.util.* ;
import java.io.*; 
import java.util.*;

// https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_843261

public class MaxNonAdjacentSum {
	static int max=Integer.MIN_VALUE;
	// Recursive
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		max=Integer.MIN_VALUE;
		function(0,nums.size(),0,nums);
		return max;
	}

	static void function(int index , int n , int curr , ArrayList<Integer> nums)
	{
		if(index>=n)
		{
			max = Math.max(max , curr);
			return;
		}

		function(index+2,n,curr+nums.get(index),nums);
		function(index+1,n,curr,nums);
	}


	// Memorization
	public static int maximumNonAdjacentSumMemo(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size();
		Integer[] dp = new Integer[n];
		return functionMemo(0,n,nums,dp);
	}

	static int functionMemo(int index , int n , ArrayList<Integer> nums , Integer[] dp)
	{
		if(index>=n) return 0;
		if(dp[index] != null) return dp[index];

		int a = nums.get(index)+functionMemo(index+2,n,nums,dp);
		int b = functionMemo(index+1,n,nums,dp);

		return dp[index] = Math.max(a,b);
	}
}