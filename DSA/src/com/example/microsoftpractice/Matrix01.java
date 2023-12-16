package com.example.microsoftpractice;

// https://leetcode.com/problems/01-matrix/

import java.util.*;

public class Matrix01 {
	int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

	public int[][] updateMatrix(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int[][] res = new int[row][col];

		for(int i = 0 ; i<row;i++)
		{
			for(int j=0; j <col ; j++)
			{
				if(mat[i][j] == 1)
				{
					int count = bfs(mat , i , j , row , col);
					res[i][j] = count;
				}
			}
		}

		return res;
	}

	int bfs(int[][] mat , int r , int c , int row , int col)
	{
		boolean[][] isVisited = new boolean[row][col];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{r,c,0});
		isVisited[r][c] = true;

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i=0 ; i<size; i++)
			{
				int[] curr = queue.poll();
				int ro = curr[0];
				int co = curr[1];
				int di = curr[2];

				if(mat[ro][co] == 0) return di;

				for(int[] dir : dirs)
				{
					int cR = ro+dir[0];
					int cC = co+dir[1];

					if(cR<0 || cR>=row || cC<0 || cC>=col || isVisited[cR][cC]) continue;

					queue.offer(new int[]{cR,cC,di+1});
				}
			}
		}
		return -1;
	}
}