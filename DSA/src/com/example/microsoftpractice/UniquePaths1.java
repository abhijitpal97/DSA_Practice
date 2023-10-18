package com.example.microsoftpractice;

// https://leetcode.com/problems/unique-paths/description/

public class UniquePaths1 {
	public int uniquePaths(int m, int n) {
		Integer[][] dp = new Integer[m+1][n+1];
		return solution(0 , 0 , m-1 , n-1 , m , n , dp);
	}

	int solution(int srcR , int srcC , int destR , int destC , int row , int col , Integer[][] dp)
	{
		if(srcR == destR && srcC == destC) return 1;
		if(srcR>=row || srcC>=col) return 0 ;
		if(dp[srcR][srcC] != null) return dp[srcR][srcC];

		int d = solution(srcR+1 , srcC , destR , destC , row , col , dp);
		int r = solution(srcR , srcC+1 , destR , destC , row , col , dp);

		return dp[srcR][srcC] = d+r;
	}
}