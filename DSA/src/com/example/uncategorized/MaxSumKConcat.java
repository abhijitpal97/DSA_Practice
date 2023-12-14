package com.example.uncategorized;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/maximum-subarray-sum-after-k-concatenation_874513

public class MaxSumKConcat {

	public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
		// Write your code here.
		int len = n * k;
		int[] curr = new int[len];
		for(int i = 0 ; i<len ; i++)
		{
			curr[i] = arr.get(i%n);
		}

		int sumSoFar = curr[0];
		int maxSum = curr[0];

		for(int i = 1 ; i<len ; i++)
		{
			sumSoFar = Math.max(sumSoFar+curr[i] , curr[i]);
			maxSum = Math.max(maxSum , sumSoFar);
		}

		return maxSum;
	}
}