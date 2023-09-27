package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/longest-decreasing-subsequence_800300

public class LongestDecreasingSubsequence {
	public static int LDS(int[] arr) {
		// Write your code here.
		int n = arr.length;
		Integer[][] dp = new Integer[n+1][n+1];

		return function(arr,0,-1,n,dp);
	}

	static int function(int[] arr , int index , int prev , int n ,Integer[][] dp)
	{
		if(index>= n) return 0;
		if(dp[index][prev+1] != null) return dp[index][prev+1];

		int take = Integer.MIN_VALUE;
		int notTake = 0;

		if(prev == -1 || arr[index]<arr[prev]) 
		{
			take = 1+function(arr,index+1 , index , n ,dp);
		}
		notTake = function(arr,index+1,prev,n, dp);

		return dp[index][prev+1] = Math.max(take , notTake);
	}	
}