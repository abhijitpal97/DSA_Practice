package com.example.amazonpractice;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

public class DiceRollWithTargetSum {
	static int count = 0 ;

	public static void main(String[] args)
	{
		int res = numRollsToTarget(30, 30, 500);
		System.out.println(res);
	}

	public static int numRollsToTarget(int n, int k, int target) {
		count = 0 ;
		function(n , k , target);
		return count;
	}

	static void function(int n, int k, int target)
	{
		if(n==0 && target==0)
		{
			count++;
			return;
		}

		if(n==0 && target != 0) return;
		if(n != 0 && target == 0) return;

		for(int i = 1 ; i<=k ; i++)
		{
			if(target>=i) function(n-1 , k , target-i);
		}
	}

	// Memorization

	public int numRollsToTargetMemo(int n, int k, int target) {
		if(n==1)
		{
			if(k>=target)
				return 1;
			else
				return 0;
		}
		Integer[][] dp = new Integer[n+1][target+1];

		return functionMemo(n , k , target , dp);        
	}

	int functionMemo(int n, int k, int target , Integer[][] dp)
	{
		if(n==0 && target==0) return 1;        
		if(n==0 && target != 0) return 0;
		if(n != 0 && target == 0) return 0 ;
		if(dp[n][target] != null) return dp[n][target];

		int sum = 0;
		for(int i = 1 ; i<=k ; i++)
		{
			if(target>=i) 
			{
				sum += functionMemo(n-1 , k , target-i , dp);
				sum = sum%1000000007;
			}
		}

		return dp[n][target] = sum;
	}
}