package com.example.microsoftpractice;


public class DesignTicTacToe {
	int[][] board;
	int bd;
	public DesignTicTacToe(int n) {
		// Initialize your data structure here.
		board = new int[n][n];
		bd=n;

	}

	public int move(int row, int col, int player) {
		// Write your code here.
		char ch ='O';
		if(player == 1) ch = 'X';

		if (board[row][col] != 0) {
			// This cell is already occupied.
			return 0;
		}


		board[row][col] = ch;

		if(isValid(board , ch , bd , row , col)) return player;
		return 0;
	}

	boolean isValid(int[][] board , char ch , int n , int row , int col)
	{
		int count = 0;
		for(int i = 0 ; i<n;i++)
		{
			if(board[i][col] != ch) break;
			count++;
		}
		if(count == n) return true;
		count = 0;
		for(int i = 0 ; i<n;i++)
		{
			if(board[row][i] != ch) break;
			count++;
		}
		if(count == n) return true;
		count = 0;
		int lR = 0;
		int lC = 0;
		while(lR<n && lC<n)
		{
			if(board[lR][lC] != ch) break;
			lR++;
			lC++;
			count++;
		}
		if(count == n) return true;
		count = 0;
		lR = 0;
		lC = n-1;
		while(lR<n && lC>=0)
		{
			if(board[lR][lC] != ch) break;
			lR++;
			lC--;
			count++;
		}
		if(count == n) return true;

		return false;
	}
}