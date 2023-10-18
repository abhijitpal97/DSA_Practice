package LeetCodePOTD;

// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/

public class NumWaysToStay_1510 {
	public int numWays(int steps, int arrLen) {
		Integer[][] dp = new Integer[steps+1][steps+1];
		return function(steps , arrLen , dp , 0)%1000000007;
	}

	int function(int step , int len , Integer[][] dp , int curr)
	{
		if(step == 0 && curr == 0) return 1;
		if(step == 0 && curr != 0) return 0;

		if(dp[step][curr] != null) return dp[step][curr];


		long s = function(step-1 , len , dp , curr);
		long r = 0;
		long l = 0;
		if(curr<len-1) r = function(step-1 , len , dp , curr+1);
		if(curr>0) l = function(step-1 , len , dp , curr-1);


		return dp[step][curr] = (int)((r+l+s)%1000000007);
	}
}