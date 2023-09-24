package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

public class ShortestPathWithKObstacleRemove {

	public int shortestPath(int[][] grid, int k) {
		int res=0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][][] isVisited = new boolean[row][col][k+1];
		Queue<int[]> queue = new LinkedList<>(); 
		queue.add(new int[]{0, 0, k});

		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				int x = curr[0];
				int y = curr[1];
				int obs = curr[2];

				if(x == row - 1 && y == col - 1 && obs >= 0)   return res; 

				if(obs < 0 || isVisited[x][y][obs] == true)  continue;

				isVisited[x][y][obs] = true;

				if(x - 1 >= 0){
					queue.add(new int[]{x - 1, y, obs - grid[x - 1][y]});
				}

				// down
				if(x + 1 < row){
					queue.add(new int[]{x + 1, y, obs - grid[x + 1][y]});
				}

				// left
				if(y - 1 >= 0){
					queue.add(new int[]{x , y - 1, obs - grid[x][y - 1]});
				}

				// right
				if(y + 1 < col){
					queue.add(new int[]{x , y + 1, obs - grid[x][y + 1]});
				}
			}

			res++;
		}

		return -1;
	}
}