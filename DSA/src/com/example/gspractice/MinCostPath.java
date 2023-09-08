package com.example.gspractice;

public class MinCostPath 
{
	public static int minCostPath(int[][] cost, int x, int y) 
	{
		//Your code goes here
		int n = cost.length;
		int m = cost[0].length;

		Integer[][] dp = new Integer[n][m];
		return dfs(x-1 , y-1 , n , m , cost , dp);		
	}

	static int dfs(int r , int c , int row , int col , int[][] cost , Integer[][] dp)
	{
		if(r<0 || c < 0) return Integer.MAX_VALUE;

		if(r==0 && c == 0) return cost[r][c];

		if(dp[r][c] != null) return dp[r][c];

		int down = dfs(r-1,c,row,col , cost , dp);
		int diag = dfs(r-1,c-1,row,col ,  cost , dp);
		int righ = dfs(r,c-1,row,col , cost , dp);

		return dp[r][c] = cost[r][c] + Math.min(down, Math.min(diag , righ));
	}


}