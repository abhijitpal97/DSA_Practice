package com.example.amazonpractice;

// https://www.codingninjas.com/studio/problems/gold-mine-problem_799363

public class MaxGoldCollected {
	public static int maxGoldCollected(int[][] mine, int n, int m) {
		// Write your code here.
		int max = 0;
		Integer[][] dp = new Integer[n+1][m+1];
		for(int i = 0; i<n;i++)
		{
			int col = dfs(i , 0, mine , n , m , dp);
			max = Math.max(col , max);
		}

		return max;
	}

	static int dfs(int x , int y , int[][] mine , int n , int m , Integer[][] dp)
	{
		if(x<0 || x>=n || y<0 || y>=m) return 0;
		if(dp[x][y] != null) return dp[x][y];

		int ri = dfs(x,y+1,mine,n,m,dp);
		int lD = dfs(x+1,y+1,mine,n,m,dp);
		int uD = dfs(x-1,y+1,mine,n,m,dp);

		return dp[x][y] = mine[x][y]+Math.max(ri , Math.max(lD , uD));

	}
}

