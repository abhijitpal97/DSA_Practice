package LeetCodePOTD;

// https://leetcode.com/problems/perfect-squares/description/

public class PerfectSquare_0802 {
	public int numSquares(int n) {
		Integer[] dp = new Integer[n+1];
		return function(n , dp);        
	}


	int function(int n , Integer[] dp)
	{
		if(n==0) return 0;
		if(dp[n] != null) return dp[n];

		int ans = Integer.MAX_VALUE;

		for(int i=1;i*i<=n; i++)
		{
			ans = Math.min(ans , 1+function(n-(i*i) , dp));
		}
		return dp[n] = ans;
	}
}