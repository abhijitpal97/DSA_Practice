package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MaximumChocholatePick_Hard2608 {
	static int[] dirs = new int[]{0,1,-1};
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		Integer[][][] dp = new Integer[r][c][c];
		return function(0 , 0 , c-1 , r , c , grid , dp);
	}

	static int function(int r , int c1 , int c2 , int row , int col , int[][] grid , Integer[][][] dp)
	{
		if(r == row || c1<0 || c1>=col || c2<0 || c2>=col || c1>c2) return 0;
		if(dp[r][c1][c2] != null) return dp[r][c1][c2];

		int max = 0;
		for(int dir : dirs)
		{
			for(int dir1 : dirs)
			{
				max = Math.max(max , 
						function(r+1 , c1+dir , c2+dir1 , row , col , grid , dp));
			}
		}

		if(c1 != c2) max += grid[r][c2];

		return dp[r][c1][c2] = (max+grid[r][c1]);
	}
}