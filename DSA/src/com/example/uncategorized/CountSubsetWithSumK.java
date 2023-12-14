package com.example.uncategorized;
import java.util.*;
import java.io.*;

// https://www.codingninjas.com/studio/problems/number-of-subsets_3952532

public class CountSubsetWithSumK {
	static int count = 0;
	static int MOD = 1000000007;
	// Recursion
	public static int findWays(int num[], int tar) {
		// Write your code here.
		count = 0;
		function(0 , tar , 0 , num.length , num);
		return count;
	}

	static void function(int index , int target , int curr , int n , int[] nums)
	{

		if(index >= n)
		{
			if(curr == target) count = (count+1)%MOD;
			return;
		}

		function(index+1 , target , curr+nums[index] , n , nums);
		function(index+1 , target , curr , n , nums);
	}

	//Memorization
	public static int findWaysMemo(int num[], int tar) {
		// Write your code here.
		int n = num.length;
		Integer[][] dp = new Integer[n][tar+1];
		return functionMemo(0 , tar , n , num , dp);

	}

	static int functionMemo(int index , int target , int n , int[] nums , Integer[][] dp)
	{
		if(target<0) return 0;

		if(index == n)
		{
			if(target == 0) return 1;
			return 0;
		}

		if(dp[index][target] != null) return dp[index][target];

		int pick = functionMemo(index+1 , target-nums[index] ,  n , nums , dp);
		int notPick = functionMemo(index+1 , target , n , nums , dp);

		return dp[index][target] = (pick+notPick)%MOD;

	}	
}