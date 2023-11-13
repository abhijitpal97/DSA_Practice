package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/hard_6581443
// https://leetcode.com/problems/unique-paths-iii/description/
// Unique Path 3

public class RobotPaths_Hard1211 {
	public static int robotPaths(int n, int m, int arr[][]) {
		// Write your code here..
		int empty = 0;
		boolean[][] isVisited = new boolean[n][m];
		int sR = 0;
		int sC = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(arr[i][j] == 0) empty++;
				if(arr[i][j] == 1 )
				{
					sR = i;
					sC = j;
					empty++;
				}
			}
		}
		return dfs(n , m , arr , sR , sC , isVisited , empty);

	}

	static int dfs(int row , int col , int[][] arr , int r , int c , 
			boolean[][] isVisited , int empty)
	{
		if(r<0 || r>=row || c<0 || c>=col || arr[r][c] == -1 || isVisited[r][c]) return 0;
		if(arr[r][c] == 2)
		{
			if(empty == 0) return 1;
			else return 0;
		}

		isVisited[r][c] = true;
		empty--;
		int left = dfs(row,col , arr , r , c-1 , isVisited,empty);
		int right = dfs(row,col , arr , r , c+1 , isVisited,empty);
		int up = dfs(row,col , arr , r-1 , c , isVisited,empty);
		int down = dfs(row,col , arr , r+1 , c , isVisited,empty);

		isVisited[r][c] = false;
		empty++;

		return left+right+up+down;
	}

}