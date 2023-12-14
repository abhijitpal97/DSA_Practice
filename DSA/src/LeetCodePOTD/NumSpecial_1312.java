package LeetCodePOTD;

// https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/

public class NumSpecial_1312 {
	public int numSpecial(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		boolean[][] isVisited = new boolean[row][col];
		int count = 0;

		for(int i = 0;i<row;i++)
		{
			for(int j=0; j<col; j++)
			{
				if(!isVisited[i][j] && mat[i][j] == 1)
				{
					isVisited[i][j] = true;
					if(dfs(i , j , row , col , mat , isVisited)) count++;
				}
			}
		}

		return count;
	}

	boolean dfs(int r , int c , int row , int col , int[][] mat , boolean[][] isVisited)
	{
		boolean flag = true;
		for(int i=0;i<col;i++)
		{
			if(mat[r][i] == 1 && i != c)
			{
				isVisited[r][i] = true;
				flag = false;
			}
		}

		for(int i=0;i<row;i++)
		{
			if(mat[i][c] == 1 && i != r)
			{
				isVisited[i][c] = true;
				flag = false;
			}
		}

		return flag;
	}
}