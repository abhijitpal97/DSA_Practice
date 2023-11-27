package StriverSheet175AndLoveBabbar450;
// https://leetcode.com/problems/super-egg-drop/

public class EggDropProblem {
	public int superEggDrop(int k, int n) {
		Integer[][] dp = new Integer[n+1][k+1];
		return solve(k , n , dp);
	}

	int solve(int k , int n , Integer[][] dp)
	{
		if(n==0 || n==1 || k==1) return n;
		if(dp[n][k] != null) return dp[n][k];
		int l = 1;
		int h = n;
		int ans = Integer.MAX_VALUE;
		while(l<=h)
		{
			int mid = (l+h)/2;
			int left = solve(k-1,mid-1,dp);
			int right = solve(k, n-mid,dp);

			int temp = 1+Math.max(left , right);
			if(left<right) l = mid+1;
			else h = mid-1;

			ans = Math.min(ans , temp);
		}

		return dp[n][k] = ans;
	}
}