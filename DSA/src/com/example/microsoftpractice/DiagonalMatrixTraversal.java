package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/diagonal-traverse/description/

public class DiagonalMatrixTraversal {
	public int[] findDiagonalOrder(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int[] res = new int[row*col];
		boolean flag = false;
		int index = 0;
		for(int i = 0; i<col; i++)
		{
			for(int j = 0 ; j<row ; j++)
			{
				if(mat[j][i] == (int)1e9) continue;
				List<Integer> list = constructData(j , i , row , col , flag , mat);
				flag = !flag;
				for(int x : list)
				{
					res[index] = x;
					index++;
				}
			}
		}

		return res;
	}

	List<Integer> constructData(int r , int c , int row , int col , boolean flag , int[][] mat)
	{
		List<Integer> list = new ArrayList<>();

		while(r>=0 && r<row && c>=0 && c<col)
		{
			list.add(mat[r][c]);
			mat[r][c] = (int)1e9;
			r--;
			c++;
		} 

		if(flag) Collections.reverse(list);
		return list;
	}
}