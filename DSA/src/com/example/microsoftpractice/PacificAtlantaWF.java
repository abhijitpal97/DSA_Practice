package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/pacific-atlantic-water-flow/description/

public class PacificAtlantaWF {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int row = heights.length;
		int col = heights[0].length;

		boolean[][] isVisitedAtl = new boolean[row][col];
		boolean[][] isVisitedPcf = new boolean[row][col];

		for(int i = 0 ; i<col ; i++) dfs(0 , i , heights , isVisitedPcf , -1 , row , col);
		for(int i = 0 ; i<row ; i++) dfs(i , 0 , heights , isVisitedPcf , -1, row , col);

		for(int i = 0 ; i<row ; i++) dfs(i , col-1 , heights , isVisitedAtl , -1, row , col);
		for(int i = 0 ; i<col ; i++) dfs(row-1 , i , heights , isVisitedAtl , -1, row , col);

		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(isVisitedAtl[i][j] == true && isVisitedPcf[i][j] == true)
				{
					result.add(new ArrayList<>(Arrays.asList(i , j)));
				}
			}
		}

		return result;
	}

	void dfs(int r , int c , int[][] heights , boolean[][] isVisited  , int prev , int row , int col)
	{
		if(r<0 || r>=row || c<0 || c>=col || heights[r][c]<prev || isVisited[r][c]) return;

		isVisited[r][c] = true;

		dfs(r+1 , c , heights , isVisited , heights[r][c] , row , col);
		dfs(r-1 , c , heights , isVisited , heights[r][c] , row , col);
		dfs(r , c+1 , heights , isVisited , heights[r][c] , row , col);
		dfs(r , c-1 , heights , isVisited , heights[r][c] , row , col);
	}
}