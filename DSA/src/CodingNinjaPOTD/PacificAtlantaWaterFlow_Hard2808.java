package CodingNinjaPOTD;

import java.util.* ;
import java.io.*; 
import java.util.List;

public class PacificAtlantaWaterFlow_Hard2808 {
	public static List<List<Integer>> waterFlow(int[][] a, int n, int m) {
		// Write your code here.
		boolean[][] visitedAtl = new boolean[n][m];
		boolean[][] visitedPac = new boolean[n][m];

		//validate Pacific
		for(int i = 0 ; i<n;i++) dfs(a , i , 0 , visitedPac , n , m , -1);
		for(int i = 0 ; i<m;i++) dfs(a , 0 , i , visitedPac , n , m , -1);

		//validate Atlantic
		for(int i = 0 ; i<n;i++) dfs(a , i , m-1 , visitedAtl , n , m , -1);
		for(int i = 0 ; i<m;i++) dfs(a , n-1 , i , visitedAtl , n , m , -1);

		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i <n ; i++)
		{
			for(int j=0; j<m; j++)
			{
				if(visitedAtl[i][j] && visitedPac[i][j]) list.add(new ArrayList<>(Arrays.asList(i,j)));
			}
		}

		return list;
	}

	static void dfs(int[][] a , int r , int c , boolean[][] isVisited , int row , int col , int prev)
	{
		if(r<0 || r>=row || c<0 || c>= col || isVisited[r][c] || a[r][c]<prev) return;

		isVisited[r][c] = true;

		dfs(a,r+1,c,isVisited,row,col,a[r][c]);
		dfs(a,r-1,c,isVisited,row,col,a[r][c]);
		dfs(a,r,c+1,isVisited,row,col,a[r][c]);
		dfs(a,r,c-1,isVisited,row,col,a[r][c]);
	}
}
