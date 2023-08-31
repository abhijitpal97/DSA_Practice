package com.example.amazonpractice;

public class MaxProduct2DArray {
	long product=-1;
	public int maxProductPath(int[][] grid) {
		dfs(0,0,grid,1);
		int mod=1000000007;
		return (int)(product%mod);
	}

	public void dfs(int i,int j,int [][]grid,long curr)
	{
		if (i==grid.length && j==grid[0].length || i==grid.length-1 &&j==grid[0].length || i==grid.length&&j==grid[0].length-1)
		{
			product=Math.max(product,curr);
			return;
		}

		if(i>=grid.length || j>=grid[0].length)
		{
			return;
		} 

		if(grid[i][j]==0)
		{
			product=Math.max(product,0);
			return;
		}

		dfs(i+1,j,grid,curr*grid[i][j]);
		dfs(i,j+1,grid,curr*grid[i][j]);




	}
}