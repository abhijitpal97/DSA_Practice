package com.example.microsoftpractice;

// https://leetcode.com/problems/number-of-provinces/description/

public class NumberofProvience {
	public int findCircleNum(int[][] isConnected) {
		int row = isConnected.length;
		boolean[] isvisited = new boolean[row];

		int count = 0;
		for(int i = 0 ; i<row ; i++)
		{
			if(! isvisited[i])
			{
				dfs(i , isConnected , isvisited);
				count++;
			}
		}

		return count;
	}

	void dfs(int src , int[][] isConnected , boolean[] isVisited)
	{
		isVisited[src] = true;

		for(int i = 0 ; i<isConnected[0].length; i++ )
		{
			if(isConnected[src][i] == 1 && !isVisited[i]) dfs(i , isConnected , isVisited);
		}
	}
}
