package com.example.gspractice;

public class MinSumDifferenceTwoArrayPartition {
	static int min = Integer.MAX_VALUE;
	public static int minSubsetSumDifference(int []arr, int n) {
		// Write your code here.
		min = Integer.MAX_VALUE;
		int total =0;
		for(int i:arr) total += i;
		function(arr,0,total , 0,n);
		return min;
	}

	static void function(int[] arr , int index , int total , int sum , int n)
	{
		if(index >=n)
		{
			min =Math.min(min ,Math.abs( total - sum));
			return;
		}

		function(arr , index+1 , total-arr[index] , sum+arr[index] , n);
		function(arr , index+1 , total , sum , n);
	}

	// Memorization

	public static int minSubsetSumDifferenceMemo(int []arr, int n) {
		// Write your code here.
		int sum = 0;
		for(int i=0;i<arr.length;i++) sum +=arr[i];
		Integer[][] dp = new Integer[n][sum];
		return functionMemo(arr,0,0 , 0, dp , n);

	}

	static int functionMemo(int[] arr , int index , int s1 , int s2 , Integer[][] dp , int n)
	{
		if(index == n) return Math.abs(s1-s2);
		if(dp[index][Math.abs(s1-s2)] != null) return dp[index][Math.abs(s1-s2)];


		int pick = functionMemo(arr , index+1 , s1+arr[index] , s2, dp,n);
		int notPick = functionMemo(arr , index+1 , s1 , s2+arr[index] , dp , n);

		return dp[index][Math.abs(s1-s2)] = Math.min(pick , notPick);

	}
}