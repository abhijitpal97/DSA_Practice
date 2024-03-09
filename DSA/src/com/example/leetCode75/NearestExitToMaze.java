package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/

public class NearestExitToMaze {
	public int nearestExit(char[][] maze, int[] entrance) {
		int row = maze.length;
		int col = maze[0].length;
		boolean[][] isVisited = new boolean[row][col];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(entrance);
		isVisited[entrance[0]][entrance[1]] = true;
		int steps = 0;
		maze[entrance[0]][entrance[1]] = '+';
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i = 0 ; i<size; i++)
			{
				int[] curr = queue.poll();

				for(int[] dir : dirs)
				{
					int cR = curr[0]+dir[0];
					int cC = curr[1]+dir[1];
					if(cR>= row || cC<0 || cC>=col || cR<0)
					{
						if(maze[curr[0]][curr[1]] != '+') return steps;
						else continue;
					}
					if( isVisited[cR][cC] ||maze[cR][cC]=='+') continue;
					queue.offer(new int[]{cR,cC});
					isVisited[cR][cC] = true;
				}
			}

			steps++;
		}

		return -1;
	}
}