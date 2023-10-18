package com.example.gspractice;

// https://leetcode.com/problems/knight-probability-in-chessboard/description/

public class KnightProbablity {
	public double knightProbability(int n, int k, int row, int column) {
		if(k==0) return 1.0;
		int r = n;
		int c = n;

		Double[][][] dp = new Double[r+1][c+1][k+1];
		double moves = helper(k , row , column , dp , r , c);

		return moves/Math.pow(8 , k);
	}

	double helper(int k , int r , int c , Double[][][] dp , int row , int col)
	{
		if(! isSafe(r,c,row,col)) return 0;
		if(k==0) return 1.0;

		if(dp[r][c][k] != null) return dp[r][c][k];

		return dp[r][c][k] = helper(k-1,r-1,c+2,dp , row , col) + helper(k-1,r-1,c-2,dp , row , col) + 
				helper(k-1,r-2,c+1,dp , row , col) + helper(k-1,r-2,c-1,dp , row , col) + 
				helper(k-1,r+1,c+2,dp , row , col) + helper(k-1,r+1,c-2,dp , row , col) + 
				helper(k-1,r+2,c+1,dp , row , col) + helper(k-1,r+2,c-1,dp , row , col);

	}

	boolean isSafe(int r , int c , int row , int col)
	{
		if(r>=0 && r<row && c>=0 && c<col) return true;
		return false;
	}
}