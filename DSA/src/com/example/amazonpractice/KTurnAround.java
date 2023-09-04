package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

public class KTurnAround {
	static int mod = 1000000007;
// Dp table to store result of all states.
	static Integer[][][][] dp = new Integer[51][51][51][2];
	
	public static int kTurnAround(int n, int m, int k) {
		// Write your code here
		int ans = (countPath(n - 2,m - 1,k,1) % mod + countPath(n - 1,m - 2,k,0) % mod) % mod;
		return ans;
	}

	static int countPath(int i, int j, int k, int d)
{
	// Base Conditions
	// If our current row index and column index becomes invalid, we can return 0 as a failure
	if(i < 0 || j < 0)
	{
		return 0;
	}	
	// If we reach the final bottom right point, we will return 1 as success.
	if(i == 0 && j == 0)
	{
		return 1;
	}	
	// If 'K' is equal to zero indicating no further turns:
	if(k == 0)
	{
		// If we are in the last row and our current direction is 0, then we can return 1 as a success
		// Or, if we are in the last column and our current direction is 1, then we can return 1 as a success
		if((i == 0 && d == 0) || (j == 0 && d == 1))
		{
			return 1;
		}
		// Otherwise, we can return zero as a failure.
		return 0;
	}
	// If we had already found the result.
	if(dp[i][j][k][d] != null)
	{
		return dp[i][j][k][d];
	}
	if(d == 0)
	{
		return dp[i][j][k][d] = (countPath(i, j - 1, k, d) % mod + countPath(i - 1, j, k - 1, d ^ 1) % mod) % mod;
	}	
	return dp[i][j][k][d] = (countPath(i - 1, j, k, d) % mod + countPath(i, j - 1, k - 1, d ^ 1) % mod) % mod;
}
}