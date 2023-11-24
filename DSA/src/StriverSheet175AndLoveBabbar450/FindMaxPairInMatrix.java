package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/find-a-specific-pair-in-the-matrix_1115467

public class FindMaxPairInMatrix {
	public static int findMaxValue(int mat[][], int n) {
		// Write your code here.
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[n][n];

		dp[0][0] = mat[0][0];

		for(int i=1;i<n;i++) dp[i][0] = Math.min(dp[i-1][0] , mat[i][0]);

		for(int j=1;j<n;j++) dp[0][j] = Math.min(dp[0][j-1] , mat[0][j]);

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				max = Math.max(max , mat[i][j] - dp[i-1][j-1]);
				dp[i][j] = Math.min(mat[i][j] , Math.min(dp[i-1][j] , dp[i][j-1]));
			}
		}

		return max;
	}
}
