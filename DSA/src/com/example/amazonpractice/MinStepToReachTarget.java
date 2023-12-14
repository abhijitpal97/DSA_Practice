package com.example.amazonpractice;

import java.util.*;

// https://www.geeksforgeeks.org/problems/steps-by-knight5927/1

class KnightReachPair
{
	int x;
	int y;
	int val;

	KnightReachPair(int x, int y , int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
}



public class MinStepToReachTarget
{
	//Function to find out minimum steps Knight needs to reach target position.
	public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
	{
		// Code here
		boolean[][] isVisited = new boolean[N+1][N+1];
		Queue<KnightReachPair> queue = new LinkedList<>();
		int[][] dirs = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
		queue.offer(new KnightReachPair(KnightPos[0],KnightPos[1],0));
		while(!queue.isEmpty())
		{
			KnightReachPair pr = queue.poll();
			if(pr.x==TargetPos[0] && pr.y==TargetPos[1]) return pr.val;

			for(int[] dir : dirs)
			{
				int row = pr.x+dir[0];
				int col = pr.y+dir[1];
				if(isValid(row,col,N) && !isVisited[row][col])
				{
					isVisited[row][col] = true;
					queue.add(new KnightReachPair(row , col ,pr.val+1)); 
				}
			}
		}
		return -1;
	}

	boolean isValid(int row , int col , int N)
	{
		if(row<0 || row>N || col<0 || col>N) return false;
		return true;
	}
}