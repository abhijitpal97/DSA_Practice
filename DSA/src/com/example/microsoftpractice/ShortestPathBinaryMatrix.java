package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathBinaryMatrix {
	int[][] dirs = new int[][]{{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
	public int shortestPathBinaryMatrix(int[][] grid) {
		if(grid[0][0] == 1) return -1;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] isVisited = new boolean[row][col];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0,1});
		isVisited[0][0] = true;

		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				int sR = curr[0];
				int sC = curr[1];
				int sP = curr[2];
				if(sR == row-1 && sC== col-1) return sP;
				for(int[] dir:dirs)
				{
					int cR = sR+dir[0];
					int cC = sC+dir[1];

					if(cR<0 || cR>=row || cC<0 || cC>=col || grid[cR][cC] == 1 || isVisited[cR][cC]) continue;
					queue.offer(new int[]{cR,cC,sP+1});
					isVisited[cR][cC] = true;
				}
			}
		}

		return -1;
	}
}