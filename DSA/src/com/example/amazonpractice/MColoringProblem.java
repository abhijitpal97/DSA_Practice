package com.example.amazonpractice;

public class MColoringProblem {
	public static String graphColoring(int [][]mat, int m) {
		// Write your code here

		int colors = mat.length;
		int[] color = new int[colors];

		if(solve(mat,0,m,colors , color)) return "YES";
		return "NO";
	}

	static boolean solve(int[][] mat , int src , int colors , int n , int[] color)
	{
		if(src == n) return true;

		for(int i = 1; i<=colors;i++)
		{
			if(isSafe(mat,color,i,src))
			{
				color[src] = i;
				if(solve(mat , src+1 , colors , n , color)) return true;
				color[src] = 0;
			}
		}

		return false;
	}

	static boolean isSafe(int[][] mat , int[] color , int col , int cur)
	{
		for (int i = 0; i < mat.length; i++) {
			if (mat[cur][i] == 1 && color[i] == col) {
				return false;
			}
		}
		return true;
	}
}