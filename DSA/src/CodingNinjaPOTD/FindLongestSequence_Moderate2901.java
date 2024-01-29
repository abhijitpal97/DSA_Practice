package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/find-longest-sequence_893353

public class FindLongestSequence_Moderate2901{
	public static int findLongestOverAll(int[][] mat, int n) {
		// Write your code here.
		Integer[][] dp = new Integer[n][n];
		int ans = 1;

		for(int i =0 ; i<n ; i++)
		{
			for(int j = 0 ; j<n ; j++)
			{
				ans = Math.max(ans , helper(i , j , mat , dp , n ));
			}
		}

		return ans; 
	}

	private static int helper(int i , int j , int[][] mat , Integer[][] dp , int n)
	{
		if(i<0 || i>=n || j <0 || j>= n) return 0;
		if(dp[i][j] != null) return dp[i][j];

		if(i<n-1 && mat[i][j]+1 == mat[i+1][j]) return dp[i][j] = 1+helper(i+1,j,mat,dp,n);
		if(i>0 && mat[i][j]+1 == mat[i-1][j]) return dp[i][j] = 1+helper(i-1,j,mat,dp,n);
		if(j<n-1 && (mat[i][j]+1 == mat[i][j+1])) return dp[i][j] = 1+helper(i,j+1,mat,dp,n);
		if(j>0 && mat[i][j]+1 == mat[i][j-1]) return dp[i][j] = 1+helper(i,j-1,mat,dp,n);

		return dp[i][j] = 1;
	}
}