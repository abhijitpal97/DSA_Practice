package com.example.microsoftpractice;

// https://leetcode.com/problems/rotate-image/description/

public class RotateImageMatrix {
	public void rotate(int[][] matrix) {
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		int c = matrix[0].length-1;
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				newMatrix[j][c] = matrix[i][j];
			}
			c--;
		}

		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				matrix[i][j] = newMatrix[i][j];
			}
		}

	}
}