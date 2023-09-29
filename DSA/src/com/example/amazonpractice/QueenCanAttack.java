package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/queens-that-can-attack-the-king/description/

public class QueenCanAttack {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		char[][] board = new char[8][8];
		for(int[] queen : queens) board[queen[0]][queen[1]] = 'X';
		board[king[0]][king[1]] = 'K';



		List<List<Integer>> result = new ArrayList<>();
		int kR = king[0];
		int kC = king[1];

		//point to left straight
		int tempR = kR;
		int tempC = kC;
		for(int i=kC; i>=0 ; i--)
		{
			if(board[tempR][i] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(tempR , i)));
				break;
			}
		}
		// System.out.println(result);
		//point to right stright
		tempR = kR;
		tempC = kC;
		for(int i=kC; i<8 ; i++)
		{
			if(board[tempR][i] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(tempR , i)));
				break;
			}
		}
		//System.out.println(result);
		//point to top straight
		tempR = kR;
		tempC = kC;
		for(int i=kR; i>=0 ; i--)
		{
			if(board[i][tempC] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(i , tempC)));
				break;
			}
		}
		//System.out.println(result);
		//point to down straight
		tempR = kR;
		tempC = kC;
		for(int i=kR; i<8 ; i++)
		{
			if(board[i][tempC] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(i , tempC)));
				break;
			}
		}

		//top left diagonal
		tempR = kR;
		tempC = kC;
		while(tempR>=0 && tempC>=0)
		{
			if(board[tempR][tempC] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(tempR , tempC)));
				break;
			}
			tempR--;
			tempC--;
		}

		//top right diagonal
		tempR = kR;
		tempC = kC;
		while(tempR>=0 && tempC<8)
		{
			if(board[tempR][tempC] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(tempR , tempC)));
				break;
			}
			tempR--;
			tempC++;
		}

		//bottom left diagonal
		tempR = kR;
		tempC = kC;
		while(tempR<8 && tempC>=0)
		{
			if(board[tempR][tempC] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(tempR , tempC)));
				break;
			}
			tempR++;
			tempC--;
		}


		//bottom right diagonal
		tempR = kR;
		tempC = kC;
		while(tempR<8 && tempC<8)
		{
			if(board[tempR][tempC] == 'X')
			{
				result.add(new ArrayList<>(Arrays.asList(tempR , tempC)));
				break;
			}
			tempR++;
			tempC++;
		}

		return result;

	}
}