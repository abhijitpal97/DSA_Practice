package com.example.oracle;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/chocolate-problem_893280

public class ChocholateProblem {
	static int findMinDiff(int n, int m, ArrayList<Integer> chocolates) {
		// Write your code here.
		Collections.sort(chocolates);
		
		int start = 0;
		int end = start+m-1;
		int min = Integer.MAX_VALUE;
		while(end<n)
		{
			int temp = chocolates.get(end) -chocolates.get(start);
			min = Math.min(min , temp);
			start++;
			end++;
		}

		return min;
	}
}