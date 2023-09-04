package com.example.amazonpractice;
import java.util.*;

public class FireInTheCell {
	public static void main(String[] args)
	{
		int res = fireInTheCells(new int[][]{{1, 0, 1, 0, 1}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 0}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 0}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 0, 1, 1}, 
			{1, 1, 1, 1, 1}, 
			{1, 1, 0, 0, 1}, 
			{1, 1, 1, 1, 1}},
				14,5,8,3);
		System.out.println(res);
	}

	public static int fireInTheCells(int[][] mat, int N, int M, int X, int Y) {
		// Write your code here.

		if(
				(X == 0 && (Y != 0 && Y != M-1)) ||
				(X == N-1 && (Y != 0 && Y != M-1)) ||
				(Y == 0 && (X != 0 && X != N-1))  ||
				(Y == M-1 && (X != 0 && X != N-1))
				) return 0;

		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> positionQueue = new LinkedList<>();
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		for(int i=0 ; i<N ; i++)
		{
			for(int j = 0 ; j<M ; j++)
			{
				if(mat[i][j] == 0) 
				{
					if(i == X && j == Y) return -1;
					queue.offer(new int[]{i , j});
				}
			}
		}

		positionQueue.offer(new int[]{X,Y});
		int time =1;

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i = 0; i< size ; i++)
			{
				int[] currF = queue.poll();
				for(int[] dir : dirs)
				{
					int currFR = currF[0]+dir[0];
					int currFC = currF[1]+dir[1];

					if(currFR<0 || currFR>=N || currFC <0 || currFC>=M || mat[currFR][currFC] == 0) continue;

					queue.offer(new int[]{currFR , currFC});
					mat[currFR][currFC] = 0;
				}
			}

			int posSize = positionQueue.size();
			for(int i=0;i<posSize;i++)
			{
				int[] currP = positionQueue.poll();

				for(int[] dir : dirs)
				{
					int currPR = currP[0]+dir[0];
					int currPC = currP[1]+dir[1];

					if(currPR<0 || currPR>=N || currPC <0 || currPC>=M || mat[currPR][currPC] == 0) continue;

					if(
							(currPR == 0 && currPC != 0 && currPC != M-1) ||
							(currPR == N-1 && currPC != 0 && currPC != M-1) ||
							(currPC == 0 && currPR != 0 && currPR != N-1)  ||
							(currPC == M-1 && currPR != 0 && currPR != N-1) 
							) return time;

					positionQueue.offer(new int[]{currPR , currPC});
				}
			}

			time++;
		}

		return -1;

	}
}
