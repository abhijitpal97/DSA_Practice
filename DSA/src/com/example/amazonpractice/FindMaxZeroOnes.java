package com.example.amazonpractice;

// https://leetcode.com/problems/ones-and-zeroes/description/

public class FindMaxZeroOnes {

	// Recursion
	int res = 0;
	public int findMaxForm(String[] strs, int m, int n) {
		res = 0;
		int count = strs.length;
		int[] zeros = new int[count];
		int[] ones = new int[count];

		for(int i =0 ; i<count;i++)
		{
			int z = 0;
			int o = 0;
			for(char ch : strs[i].toCharArray())
			{
				if(ch == '0') z++;
				else if(ch == '1') o++;
			}
			zeros[i] = z;
			ones[i] = o;
		}

		function(zeros , ones , m , n , count , 0 , 0);
		return res;
	}

	void function(int[] zeros , int[] ones , int zerosC , int oneC , int n , int index , int count)
	{
		if(zerosC<0 || oneC<0) return;
		res = Math.max(res , count);
		if(index>=n) return;

		function(zeros , ones , zerosC - zeros[index] , oneC - ones[index] , n , index+1 , count+1);
		function(zeros , ones , zerosC , oneC , n , index+1 , count);
	}

	//Memorization

	public int findMaxFormMemorization(String[] strs, int m, int n) {
		Integer[][][] dp = new Integer[m+1][n+1][strs.length];

		return helper(strs , m , n , 0 , dp);
	}

	int helper(String[] strs , int m , int  n , int index , Integer[][][] dp)
	{
		if(index == strs.length) return 0;

		if(dp[m][n][index] != null) return dp[m][n][index];

		int zero = 0 ;
		int one = 0 ;

		for(int i =0 ; i<strs[index].length();i++)
		{
			char ch = strs[index].charAt(i);
			if(ch == '0') zero++;
			else if(ch == '1') one++;

			if(zero>m || one >n) return dp[m][n][index] = helper(strs , m , n , index+1 , dp);
		}

		return dp[m][n][index] = Math.max(1+helper(strs , m-zero , n-one , index+1 , dp) , 
				helper(strs , m , n , index+1 , dp));
	}

}