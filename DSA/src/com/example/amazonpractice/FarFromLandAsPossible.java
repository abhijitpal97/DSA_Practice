package com.example.amazonpractice;

import java.util.*;

public class FarFromLandAsPossible {
	public int maxDistance(int[][] grid) {
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		Queue<int[]> queue = new LinkedList<>();
		int row = grid.length;
		int col = grid[0].length;

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(grid[i][j] == 1) queue.offer(new int[]{i , j});
			}
		}

		int result = 0;

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				int x = curr[0];
				int y = curr[1];

				for(int[] dir : dirs)
				{
					int cX = x+dir[0];
					int cY = y+dir[1];

					if(cX<0 || cX>=row || cY<0 || cY>=col || grid[cX][cY] == 1) continue;

					grid[cX][cY] = 1;
					queue.offer(new int[]{cX,cY});
				}
			}
			result++;
		}

		return result-1>0?result-1:-1;
	}
}