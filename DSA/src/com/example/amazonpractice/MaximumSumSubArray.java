package com.example.amazonpractice;
import java.util.* ;
import java.io.*;

public class MaximumSumSubArray {

	public static void main(String[] args)
	{
		ArrayList<Integer> res = maximumsumSubarray(6 , new int[] {1,2,5,-7,2,3});
		System.out.println(res);
	}


	public static ArrayList<Integer> maximumsumSubarray(int n, int arr[]) {
		// Write your code here
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		int startIndex= 0;
		int endIndex = 0;
		int newStartIndex = 0;
		for(int i = 0 ; i<n;i++)
		{
			currSum += arr[i];


			if(currSum > maxSum)
			{
				maxSum = currSum;
				startIndex = newStartIndex;
				endIndex = i;
			}
			else if(currSum == maxSum)
			{
				if(endIndex - startIndex < i-newStartIndex)
				{
					startIndex = newStartIndex;
					endIndex = i;
				}
			}

			if(currSum<0)
			{
				currSum = 0;
				newStartIndex = i+1;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for(int i = startIndex ; i<=endIndex ; i++)
		{
			list.add(arr[i]);
		}

		return list;
	}
}
