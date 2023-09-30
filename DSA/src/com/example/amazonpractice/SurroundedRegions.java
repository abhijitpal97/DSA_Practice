package com.example.amazonpractice;

// https://leetcode.com/problems/surrounded-regions/description/

public class SurroundedRegions {
	public void solve(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		boolean[][] isVisited = new boolean[row][col];

		for(int i=0;i<col;i++)
		{
			if(board[0][i] == 'O') dfs(board , isVisited , 0 ,i, row , col);
		}

		for(int i=0;i<row;i++)
		{
			if(board[i][0] == 'O') dfs(board , isVisited , i ,0, row , col);
		}

		for(int i=0;i<col;i++)
		{
			if(board[row-1][i] == 'O') dfs(board , isVisited , row-1 ,i, row , col);
		}

		for(int i=0;i<row;i++)
		{
			if(board[i][col-1] == 'O') dfs(board , isVisited , i ,col-1, row , col);
		}

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(isVisited[i][j] == true) board[i][j] = 'O';
				else board[i][j] = 'X';
			}
		}
	}

	public void dfs(char[][] board , boolean[][] isVisited , int r , int c , int row , int col)
	{
		if(r<0 || r>=row || c<0 || c>=col || isVisited[r][c] || board[r][c] == 'X') return;

		isVisited[r][c] = true;

		dfs(board , isVisited , r+1 , c ,  row , col);
		dfs(board , isVisited , r-1 , c ,  row , col);
		dfs(board , isVisited , r , c+1 ,  row , col);
		dfs(board , isVisited , r , c-1 ,  row , col);
	}
}