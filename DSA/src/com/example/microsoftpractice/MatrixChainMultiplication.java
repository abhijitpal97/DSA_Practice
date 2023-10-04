package com.example.microsoftpractice;

// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

public class MatrixChainMultiplication{
	static int matrixMultiplication(int N, int arr[])
	{
		// code here
		return function(arr , 1 , N-1);
	}

	static int function(int[] arr , int start , int end)
	{
		if(start == end) return 0;
		int min = Integer.MAX_VALUE;

		for(int i = start ; i<end ; i++)
		{
			int steps = arr[start-1] * arr[i] * arr[end] +
					function(arr , start , i) + function(arr , i+1 , end);
			if(min>steps) min = steps;
		}

		return min;
	}

	//Memorization
	static int matrixMultiplicationMemo(int N, int arr[])
	{
		// code here
		Integer[][] dp = new Integer[N][N];
		return functionMemo(arr , 1 , N-1,dp);
	}

	static int functionMemo(int[] arr , int start , int end , Integer[][] dp)
	{
		if(start == end) return 0;
		if(dp[start][end] != null) return dp[start][end];
		int min = Integer.MAX_VALUE;

		for(int i = start ; i<end ; i++)
		{
			int steps = arr[start-1] * arr[i]*arr[end] +
					functionMemo(arr , start , i,dp) + functionMemo(arr , i+1 , end,dp);
			if(min>steps) min = steps;
		}

		return dp[start][end] = min;
	}
}