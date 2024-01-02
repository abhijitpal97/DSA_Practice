package com.example.amazonpractice;

// https://leetcode.com/problems/partition-array-for-maximum-sum/description/

public class MaxSumPartitioning {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		Integer[] dp = new Integer[n];
		return function(0 , n , dp , k , arr);
	}

	int function(int index , int n , Integer[] dp , int k , int[] arr)
	{
		if(index == n) return 0;
		if(dp[index] != null) return dp[index];

		int max = Integer.MIN_VALUE;
		int len = 0;
		int mS = Integer.MIN_VALUE;

		for(int i=index ; i <Math.min(index+k , n) ; i++)
		{
			len++;
			mS = Math.max(mS , arr[i]);
			int sum = (len*mS)+function(i+1,n , dp , k , arr);
			max = Math.max(max , sum);
		}

		return dp[index] = max;
	}
}