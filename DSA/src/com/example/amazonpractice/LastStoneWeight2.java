package com.example.amazonpractice;

import java.util.*;

public class LastStoneWeight2 {

	public static void main(String[] args)
	{
		int res = lastStoneWeightII(new int[] {31,31});
		System.out.println(res);
	}

	public static int lastStoneWeightII(int[] stones) {
		int sum = 0 ;
		int n = stones.length;

		for(int i : stones) sum +=i;

		Integer[][] dp = new Integer[n+1][sum];

		int a = function(stones , n , sum/2 , 0 , dp);
		int b = sum - a;

		return Math.abs(a-b);
	}

	static int function(int[] stones , int n , int target , int index , Integer[][] dp)
	{
		if(index>= n || target<0) return 0;

		if(dp[index][target] != null) return dp[index][target];

		int a = function(stones , n , target , index+1 , dp);
		if(target>=stones[index])
		{
			int b = stones[index]+function(stones , n , target-stones[index] , index+1 , dp);

			return dp[index][target] = Math.max(a,b);
		}

		return dp[index][target] = a;
	}
}