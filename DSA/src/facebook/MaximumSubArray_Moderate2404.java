package facebook;
import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

// https://www.naukri.com/code360/problems/maximum-subarray_893296

public class MaximumSubArray_Moderate2404 {
	public static ArrayList<Integer> maximumsumSubarray(int n, int arr[]) {
		// Write your code here
		int maxSoFar = 0;
		int maxFinal = Integer.MIN_VALUE;
		int startIndex = 0;
		int endIndex = 0;
		int newStart = 0;

		for(int i=0;i<n; i++)
		{
			maxSoFar += arr[i];

			if(maxSoFar>maxFinal) 
			{
				endIndex = i;
				maxFinal = maxSoFar;
				startIndex = newStart;
			}
			else if(maxSoFar == maxFinal)
			{
				if(endIndex - startIndex < i-newStart)
				{
					startIndex = newStart;
					endIndex = i;
				}
			}

			if(maxSoFar<0)
			{
				maxSoFar = 0;
				newStart = i+1;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for(int i = startIndex ; i<=endIndex ; i++) list.add(arr[i]);

		return list;
	}
}
