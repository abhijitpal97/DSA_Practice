package LeetCodePOTD;

// https://leetcode.com/problems/min-cost-climbing-stairs

public class MinCostClimbingStairs_1310 {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		Integer[] dp = new Integer[n];
		return Math.min(
				function(0 , n , cost , dp),
				function(1 , n , cost , dp)
				);
	}

	int function(int index , int n , int[] cost , Integer[] dp)
	{
		if(index >= n) return 0;
		if(dp[index] != null) return dp[index];

		int singleC = cost[index]+function(index+1,n,cost,dp);
		int doubleC = cost[index]+function(index+2,n,cost,dp);

		return dp[index] = Math.min(singleC , doubleC);
	}
}