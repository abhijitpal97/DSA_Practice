package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/making-a-large-island/

public class MakingALargeIsland {
	public int largestIsland(int[][] grid) {
		int randomIndex = 1000;
		Map<Integer,Integer> map = new HashMap<>();
		Map<String,Set<Integer>> connectedIsland = new HashMap<>();
		int row = grid.length;
		int col = grid[0].length;
		int zeros = 0;
		boolean[][] isVisited = new boolean[row][col];
		int max = 0;
		for(int i = 0; i <row ; i++)
		{
			for(int j = 0 ; j<col ; j++)
			{
				if(grid[i][j] == 0 ) zeros++;
				else if(grid[i][j] == 1)
				{
					dfs(grid , isVisited , i , j , row , col , map , randomIndex);
					randomIndex++;
				}
			}
		}
		if(zeros == 0) return row*col;

		for(int i = 0; i<row;i++)
		{
			for(int j = 0 ; j <col ; j++)
			{
				if(grid[i][j] == 0) checkConnectedIsland(grid , i , j , row , col , connectedIsland);
			}
		}

		for(Map.Entry<String ,Set<Integer>> m1 : connectedIsland.entrySet())
		{
			int localMax = 0;
			for(int index : m1.getValue()) localMax += map.get(index);

			max = Math.max(max , localMax);
		}

		return max+1;

	}

	void checkConnectedIsland(int[][] grid , int r , int c, int row , int col ,
			Map<String,Set<Integer>> connectedIsland)
	{
		String node = r+"#"+c;
		if(r>0)
		{
			if(grid[r-1][c] != 0)
			{
				if(connectedIsland.containsKey(node))
				{
					connectedIsland.get(node).add(grid[r-1][c]);
				}
				else
				{
					connectedIsland.put(node, new HashSet<>());
					connectedIsland.get(node).add(grid[r-1][c]);
				}
			}
		}
		if(r<row-1)
		{
			if(grid[r+1][c] != 0)
			{
				if(connectedIsland.containsKey(node))
				{
					connectedIsland.get(node).add(grid[r+1][c]);
				}
				else
				{
					connectedIsland.put(node, new HashSet<>());
					connectedIsland.get(node).add(grid[r+1][c]);
				}
			}
		}
		if(c>0)
		{
			if(grid[r][c-1] != 0)
			{
				if(connectedIsland.containsKey(node))
				{
					connectedIsland.get(node).add(grid[r][c-1]);
				}
				else
				{
					connectedIsland.put(node, new HashSet<>());
					connectedIsland.get(node).add(grid[r][c-1]);
				}
			}
		}
		if(c<col-1)
		{
			if(grid[r][c+1] != 0)
			{
				if(connectedIsland.containsKey(node))
				{
					connectedIsland.get(node).add(grid[r][c+1]);
				}
				else
				{
					connectedIsland.put(node, new HashSet<>());
					connectedIsland.get(node).add(grid[r][c+1]);
				}
			}
		}
	}

	int dfs(int[][] grid , boolean[][] isVisited , int r , int c , int row , int col ,
			Map<Integer,Integer> map , int randomIndex)
	{
		if(r<0 || r>=row || c<0 || c>=col || grid[r][c] == 0 || isVisited[r][c]) return 0 ;

		grid[r][c] = randomIndex;
		isVisited[r][c] = true;

		int dow = 1+dfs(grid , isVisited , r+1 , c , row , col , map , randomIndex);
		int ri = 1+dfs(grid , isVisited , r , c+1 , row , col , map , randomIndex);
		int up = 1+dfs(grid , isVisited , r-1 , c , row , col , map , randomIndex);
		int le = 1+dfs(grid , isVisited , r , c-1 , row , col , map , randomIndex);

		map.put(randomIndex , dow+ri+up+le -3);

		return dow+ri+up+le -3;
	}
}