package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/sort-the-matrix-diagonally/description/

public class DiagonalSortMatrix {
	public int[][] diagonalSort(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		for(int i=row-2;i>=0;i--)
		{
			int j = 0;
			int temp = i;
			List<Integer> list = new ArrayList<>();
			while(j<col && temp<row)
			{
				list.add(mat[temp][j]);
				j++;
				temp++;
			}
			Collections.sort(list);

			j=0;
			temp = i;
			for(int k = 0 ; k<list.size();k++)
			{
				mat[temp][j] = list.get(k);
				j++;
				temp++;
			}
		}

		for(int i = 1 ; i<col-1 ; i++)
		{
			int j =0;
			int temp = i;
			List<Integer> list = new ArrayList<>();
			while(j<row && temp<col)
			{
				list.add(mat[j][temp]);
				temp++;
				j++;
			}
			Collections.sort(list);
			j=0;
			temp = i;
			for(int k =0 ; k<list.size();k++)
			{
				mat[j][temp]=list.get(k);
				j++;
				temp++;
			}
		}

		return mat;
	}
}