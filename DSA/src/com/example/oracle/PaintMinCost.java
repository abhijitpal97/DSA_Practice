package com.example.oracle;

// https://www.codingninjas.com/studio/problems/paint-house_1460385

public class PaintMinCost {
	public static int minCost(int[][] cost) {
		// Write your code here.
		int n = cost.length;
		Integer[][] dp = new Integer[n][3];

		int ans = Integer.MAX_VALUE;

		for (int j = 0; j < 3; j++)
		{
			ans = Math.min(ans, getMinCost(n - 1, j, cost, dp));
		}

		return ans;
	}  

	static int getMinCost(int n , int index , int[][] cost , Integer[][] dp)
	{
		if(n==-1) return 0;
		else if(dp[n][index] != null) return dp[n][index];
		else{
			int ans = Integer.MAX_VALUE;

			for(int k=0;k<3;k++)
			{
				if(k != index)
				{
					ans = Math.min(ans , getMinCost(n-1,k,cost,dp)+cost[n][index]);
				}
			}

			return dp[n][index] = ans;
		}
	} 
}
