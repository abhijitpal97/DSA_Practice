package com.example.microsoftpractice;

// https://leetcode.com/problems/maximal-square/description/

public class MaximalSquare {
	int max = 0;
	public int maximalSquare(char[][] matrix) {
		max = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		Integer[][] dp = new Integer[row][col];

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				check(i , j , row , col , matrix , dp);
			}
		}

		return max*max;
	}

	int check(int r , int c , int row , int col , char[][] matrix , Integer[][] dp)
	{
		if(r>=row || r<0 || c<0 || c>=col || matrix[r][c]=='0') return 0;
		if(dp[r][c] != null) return dp[r][c];

		int up = check(r-1,c,row,col,matrix,dp);
		int right = check(r,c+1,row,col,matrix,dp);
		int diagonal = check(r-1,c+1,row,col,matrix,dp);

		int square = 1+Math.min(up , Math.min(right , diagonal));

		max = Math.max(max , square);
		return dp[r][c] = square;
	}
}