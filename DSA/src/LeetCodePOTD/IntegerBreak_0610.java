package LeetCodePOTD;

// https://leetcode.com/problems/integer-break/

public class IntegerBreak_0610 {
	public int integerBreak(int n) {
		Integer[][] dp = new Integer[n+1][n+1];
		return function(n-1 , n , dp);
	}

	int function(int index , int target , Integer[][] dp)
	{
		if(target == 0)  return 1;
		if(index == 0) return 1;
		if(dp[index][target] != null) return dp[index][target];

		int take = 1;
		if(index<=target) take = index * function(index , target-index , dp);
		int notTake = function(index-1 , target , dp);

		return dp[index][target] = Math.max(take , notTake);
	}
}