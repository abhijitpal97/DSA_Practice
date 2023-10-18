package com.example.microsoftpractice;

// https://leetcode.com/problems/sudoku-solver/description/

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board);
	}

	boolean solve(char[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(board[i][j] == '.')
				{
					for(char k = '1';k<='9';k++)
					{
						if(isValid(board,i,j, k))
						{
							board[i][j] = k;
							if(solve(board)) return true;
							else board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}

		return true;
	}

	boolean isValid(char[][] grid, int row, int col , int val)
	{
		for(int i=0;i<9;i++)
		{
			if(grid[i][col] == val) return false;
			if(grid[row][i] == val) return false;
			if(grid[i/3 + 3*(row/3)][i%3 + 3*(col/3)] == val) return false;
		}

		return true;
	}
}