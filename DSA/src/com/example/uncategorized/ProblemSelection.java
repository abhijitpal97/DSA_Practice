package com.example.uncategorized;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/problem-selection_2824965

public class ProblemSelection {

	public static long[] problemSelection(int[] A, int K) {

		// Write your Code here
		int n = A.length;
		long min = 0;
		long max = 0;

		int req = (n+K)/(K+1);

		Arrays.sort(A);

		for(int i = 0;i<req; i++)
		{
			min += A[i];
			max += A[n-i-1];
		}

		return new long[]{min , max};
	}
}