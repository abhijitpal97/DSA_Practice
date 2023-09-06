package com.example.uncategorized;

import java.util.*;

public class NearestExitMaze {

	public static void main(String[] args)
	{
		int res = nearestExit(new char[][]{{'.','+','+','+','+'},{'.','+','.','.','.'},{'.','+','.','+','.'},{'.','.','.','+','.'},{'+','+','+','+','.'}}, new int[] {0,0});
		System.out.println(res);
	}

	public static int nearestExit(char[][] maze, int[] entrance) {
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		int row = maze.length;
		int col = maze[0].length;
		boolean isVisited[][] = new boolean[row][col];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(entrance);
		isVisited[entrance[0]][entrance[1]] = true;
		int time = 0;
		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i = 0 ; i<size ; i++)
			{
				int[] curr = queue.poll();
				if(isExit(curr[0] , curr[1] , row , col , maze[curr[0]][curr[1]] , entrance)) return time;
				for(int[] dir : dirs)
				{
					int currR = curr[0]+dir[0];
					int currC = curr[1]+dir[1];
					if(currR<0 || currR>=row || currC<0 || currC>=col || isVisited[currR][currC]
							||maze[currR][currC] == '+') continue;

					isVisited[currR][currC] = true;
					queue.offer(new int[]{currR , currC});
				}
			}
			time++;
		}
		return -1;
	}

	static boolean isExit(int r , int c , int row , int col , char ch , int[] entrance)
	{
		if(r == entrance[0] && c == entrance[1]) return false;
		if(ch == '.' && (r==0 || r == row-1 || c == 0 || c == col-1)) return true;
		return false;
	}
}