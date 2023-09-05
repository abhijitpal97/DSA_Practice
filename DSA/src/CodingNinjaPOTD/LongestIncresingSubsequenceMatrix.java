package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class LongestIncresingSubsequenceMatrix{

	public static void main(String[] args)
	{
		int res = findLongestOverAll(new int[][] {{4,5} , {7,6}}, 2);
		System.out.println(res);
	}

	public static int findLongestOverAll(int[][] mat, int n) {
		// Write your code here.
		int row = n;
		int col = n;

		int res = 0;

		for(int i = 0 ; i<row ; i++)
		{
			for(int j = 0 ; j<col ; j++)
			{
				int ans = bfs(mat , i , j , row , col);
				res = Math.max(res , ans);
			}
		}

		return res;
	}

	private static int bfs(int[][] mat , int r , int c , int row , int col)
	{
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{r,c,mat[r][c]});
		int leng = 0;
		while(! queue.isEmpty())
		{
			int[] curr = queue.poll();
			int val = curr[2];
			for(int[] dir : dirs)
			{
				int cR = curr[0]+dir[0];
				int cC = curr[1]+dir[1];

				if(cR<0 || cR>=row || cC<0 || cC>=col || ((val+1)!= mat[cR][cC])) continue;

				//System.out.println(r+" - "+c+" -Val- "+val+" Mat- "+mat[cR][cC]);

				queue.offer(new int[]{cR,cC,mat[cR][cC]});
			}
			leng++;
		}
		//System.out.println(r+" - "+c+" - "+leng);
		return leng;
	}

	// Memorization
	public static int findLongestOverAllMemo(int[][] mat, int n) {
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