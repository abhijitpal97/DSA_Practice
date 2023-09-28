package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/path-with-minimum-effort/

class MinimumPathTuple
{
	int row;
	int col;
	int dist;

	MinimumPathTuple(int row,int col , int dist)
	{
		this.row=row;
		this.col=col;
		this.dist=dist;
	}
}


public class PathMinimumEffortDijkstra {
	public int minimumEffortPath(int[][] heights) {
		int row = heights.length;
		int col = heights[0].length;
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		int [][] effort = new int[row][col];
		Queue<MinimumPathTuple> queue = new PriorityQueue<>((a,b) -> a.dist-b.dist);
		queue.offer(new MinimumPathTuple(0,0,0));
		for(int[] eff : effort) Arrays.fill(eff , Integer.MAX_VALUE);
		effort[0][0] = 0;

		while(! queue.isEmpty())
		{
			MinimumPathTuple t1 = queue.poll();
			int r1 = t1.row;
			int c1 = t1.col;
			int d1 = t1.dist;

			if(r1 == row-1 && c1 == col-1) return  d1;
			for(int[] dir : dirs)
			{
				int cR = r1+dir[0];
				int cC = c1+dir[1];
				if (cR < 0 || cC < 0 || cR >= row || cC >= col) continue;
				int cD = Math.max(effort[r1][c1] , Math.abs(heights[cR][cC] - heights[r1][c1]));

				if(cD<effort[cR][cC])
				{
					queue.offer(new MinimumPathTuple(cR,cC,cD));
					effort[cR][cC] = cD;
				}

			}
		}

		return -1;
	}
}