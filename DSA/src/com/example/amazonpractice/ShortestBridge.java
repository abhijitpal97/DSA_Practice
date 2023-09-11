package com.example.amazonpractice;

import java.util.*;

public class ShortestBridge {
	public int shortestBridge(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int row = grid.length;
		int col = grid[0].length;

		for(int i = 0; i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(grid[i][j] == 1 && queue.isEmpty())
				{
					dfs(i , j , row , col , queue , grid);
				}
			}
		}
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				for(int[] dir : dirs)
				{
					int currR = curr[0]+dir[0];
					int currC = curr[1]+dir[1];

					if(currR<0 || currR>=row || currC<0 || currC>=col || grid[currR][currC] == -1) continue;
					if(grid[currR][currC] == 1) return curr[2];
					grid[currR][currC]=-1;
					queue.offer(new int[]{currR,currC,curr[2]+1});
				}
			}
		}

		return -1;
	}

	void dfs(int r , int c , int row , int col , Queue<int[]> queue , int[][] grid)
	{
		if(r<0 || r>= row || c<0 || c>=col || grid[r][c] != 1) return;

		queue.offer(new int[]{r,c,0});
		grid[r][c] = -1;

		dfs(r+1,c,row,col,queue,grid);
		dfs(r-1,c,row,col,queue,grid);
		dfs(r,c+1,row,col,queue,grid);
		dfs(r,c-1,row,col,queue,grid);
	}
}