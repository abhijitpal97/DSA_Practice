package com.example.microsoftpractice;

// https://leetcode.com/problems/game-of-life/

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		int[][] newBoard = new int[row][col];

		for(int i=0;i<row;i++)
		{
			for(int j = 0 ;j<col ; j++)
			{
				int count = neighbour(i , j , row , col , board);
				if(board[i][j] == 0 && count == 3) newBoard[i][j] = 1;
				else if(board[i][j] == 1)
				{
					if(count<2) newBoard[i][j] = 0;
					else if(count>3) newBoard[i][j] = 0;
					else newBoard[i][j] = 1;
				}
			}
		}

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				board[i][j] = newBoard[i][j];
			}
		}
	}

	int neighbour(int r , int c , int row , int col , int[][] board)
	{
		int[][] dirs = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
		int count=0;

		for(int[] dir : dirs)
		{
			int cR = r+dir[0];
			int cC = c+dir[1];
			if(cR>=0 && cC>=0 && cR<row && cC<col && board[cR][cC] == 1) count++;
		}

		return count;
	}
}