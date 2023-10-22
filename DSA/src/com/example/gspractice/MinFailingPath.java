package com.example.gspractice;

// https://leetcode.com/problems/minimum-falling-path-sum/description/

public class MinFailingPath {
	int minR = Integer.MAX_VALUE;
	public int minFallingPathSumRecursive(int[][] matrix) {
		minR = Integer.MAX_VALUE;
		int row = matrix.length;
		int col =matrix[0].length;
		for(int i = 0; i<col;i++)
		{
			dfsRecursive(matrix , i , 0, matrix[0][i], row , col);
		}

		return minR;
	}

	void dfsRecursive(int[][] matrix , int c , int r , int sum , int row , int col)
	{
		if(r==row-1) {
			//System.out.println(min);
			minR = Math.min(minR , sum);
			return;
		}

		if(c-1>=0 && r+1<row) dfsRecursive(matrix , c-1,r+1 , sum+matrix[r+1][c-1] , row,col);
		if(r+1<row) dfsRecursive(matrix , c,r+1 , sum+matrix[r+1][c] , row,col);
		if(c+1< col && r+1<row)  dfsRecursive(matrix , c+1,r+1 , sum+matrix[r+1][c+1] , row,col);
	}


	// Dynaming Approach - Memorization

	public int minFallingPathSumMemorization(int[][] matrix) {
		int min = Integer.MAX_VALUE;
		int row = matrix.length;
		int col =matrix[0].length;
		Integer[][] dp = new Integer[row][col];
		for(int i = 0; i<col;i++)
		{
			min = Math.min(min , dfs(matrix , i , 0 , row , col , dp ));
		}

		return min;
	}

	int dfs(int[][] matrix , int c , int r , int row , int col , Integer[][] dp)
	{
		if(c >= col || c < 0){
			return (int) Math.pow(10, 9);
		}

		if(r == row-1) return matrix[r][c];

		if(dp[r][c] != null) return dp[r][c];

		int l = matrix[r][c] + dfs(matrix , c-1,r+1 , row,col,dp);
		int s = matrix[r][c] + dfs(matrix , c,r+1 , row,col,dp);
		int ri = matrix[r][c] + dfs(matrix , c+1,r+1 , row,col,dp);

		return dp[r][c] = Math.min(l , Math.min(s , ri));
	}



}