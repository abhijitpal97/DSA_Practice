package com.example.amazonpractice;

import java.util.*;

public class FloodFillAlgorithm
{
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
		// Code here 
		int row = image.length;
		int col = image[0].length;

		int color = image[sr][sc];

		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][] isVisited = new boolean[row][col];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{sr,sc});
		image[sr][sc] = newColor;
		isVisited[sr][sc] = true;
		while(! queue.isEmpty())
		{
			int[] curr = queue.poll();
			for(int[] dir : dirs)
			{
				int currR = dir[0]+curr[0];
				int currC = dir[1]+curr[1];
				if(currR<0 || currR>=row || currC<0 || currC>=col || isVisited[currR][currC]
						|| image[currR][currC] != color) continue;
				queue.offer(new int[]{currR,currC});
				image[currR][currC] = newColor;
				isVisited[currR][currC] = true;
			}
		}

		return image;
	}
}