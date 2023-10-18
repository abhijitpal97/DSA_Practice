package com.example.uncategorized;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

public class FindMedianRowWiseSortedMatrix {
	int median(int matrix[][], int R, int C) {
		// code here   
		List<Integer> list=new ArrayList<>();

		for(int i=0;i<R;i++){

			for(int j=0;j<C;j++){

				list.add(matrix[i][j]);

			}

		}

		Collections.sort(list);

		int mid=(R*C)/2;

		return list.get(mid);
	}
}