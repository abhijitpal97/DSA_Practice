package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/longest-route_1170525

public class LongestRoute_Moderate2502 {
	static int max = Integer.MIN_VALUE;
	public static int longestPath(int n, int m, int[][] mat, int sx, int sy, int dx, int dy) {
		// Write your code here
		if(mat[sx][sy] == 0) return -1;
		max = Integer.MIN_VALUE;
		boolean[][] isVisited = new boolean[n][m];
		dfs(sx , sy , dx , dy , n , m , isVisited , 0,mat);
		return max;
	}

	static void dfs(int sR , int sC , int dR , int dC , int row , int col ,boolean[][] isVisited ,
			int curr , int[][] mat)
	{
		if(sR<0 || sR>=row || sC<0 || sC>=col || mat[sR][sC] == 0 || isVisited[sR][sC]) return;
		if(sR == dR && sC == dC) max = Math.max(max , curr);

		isVisited[sR][sC] = true;

		dfs(sR+1,sC,dR,dC,row,col,isVisited , curr+1 , mat);
		dfs(sR-1,sC,dR,dC,row,col,isVisited , curr+1 , mat);
		dfs(sR,sC+1,dR,dC,row,col,isVisited , curr+1 , mat);
		dfs(sR,sC-1,dR,dC,row,col,isVisited , curr+1 , mat);

		isVisited[sR][sC] = false;
	}

}
