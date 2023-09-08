package CodingNinjaPOTD;

public class FindAllIslandAfterQueries_Moderate0809 {
	public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
		// Write your code here.
		int[][] grid = new int[n][m];
		int[] result = new int[queries.length];

		for(int i=0;i<queries.length; i++)
		{
			grid[queries[i][0]][queries[i][1]] = 1;
			result[i] = numberOfIsland(n , m , grid);
		}

		return result;
	}

	static int numberOfIsland(int n , int m , int[][]  grid)
	{
		boolean[][] isVisited = new boolean[n][m];
		int count = 0;
		for(int i =0 ; i<n;i++)
		{
			for(int j=0; j<m; j++)
			{
				if(! isVisited[i][j] && grid[i][j] == 1)
				{
					dfs(i , j , n , m , grid , isVisited);
					count++;
				}
			}
		}
		return count;
	}

	static void dfs(int r , int c , int row , int col , int[][] grid , boolean[][] isVisited)
	{
		if(r<0 || r>=row || c<0 || c>= col || grid[r][c] == 0 || isVisited[r][c]) return;

		isVisited[r][c] = true;

		dfs(r+1,c,row,col,grid,isVisited);
		dfs(r-1,c,row,col,grid,isVisited);
		dfs(r,c+1,row,col,grid,isVisited);
		dfs(r,c-1,row,col,grid,isVisited);

	}
}