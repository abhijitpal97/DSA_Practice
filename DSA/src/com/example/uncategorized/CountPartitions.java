package com.example.uncategorized;

import java.util.* ;
import java.io.*; 


public class CountPartitions {
	static int count = 0;
	static int MOD = 1000000007;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		count = 0;
		int total = 0;
		for(int i : arr) total += i;

		function(0 , n , 0 , total , d , arr);
		return count;
	}

	static void function(int index , int n , int curr , int total , int diff, int[] arr)
	{
		if(index == n)
		{
			if((curr-total) == diff)
			{
				count = (count+1)%MOD;
			}
			return;
		}

		function(index+1 , n , curr+arr[index] , total-arr[index] , diff , arr);
		function(index+1 , n , curr , total , diff , arr);
	}
}