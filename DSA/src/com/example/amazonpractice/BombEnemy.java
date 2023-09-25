package com.example.amazonpractice;

// https://leetcode.com/problems/bomb-enemy/description/

public class BombEnemy
{
	public static void main(String[] args)
	{
		int[] res = getBombPosition(new char[][] {{'.','E','.','.'},{'E','.','W','E'}
		,{'.','E','.','.'}});
		System.out.println(res[0]+" - "+res[1]);
	}
	public static int[] getBombPosition(char[][] grid)
	{
		int row = grid.length;
		int col = grid[0].length;
		int max = 0;
		int[] res = new int[2];
		for(int i=0;i<row;i++)
		{
			for(int j = 0 ; j<col ; j++)
			{
				if(grid[i][j]=='.')
				{
					int count = getMax(grid , i , j , row , col);
					if(count>max)
					{
						max = count;
						res[0]=i;
						res[i]=j;
					}
				}
			}
		}

		return res;
	}

	static int getMax(char[][] grid , int r , int c , int row , int col)
	{
		int count =0;
		// Row Wise
		for(int i = 0 ; i<row; i++)
		{
			if(grid[i][c] == 'E') count++;
			if(grid[i][c] == 'W') break;
		}
		//Column Wise
		for(int i = 0 ; i<col; i++)
		{
			if(grid[r][i] == 'E') count++;
			if(grid[r][i] == 'W') break;
		}

		return count;
	}
}