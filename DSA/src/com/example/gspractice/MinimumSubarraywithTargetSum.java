package com.example.gspractice;
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/minimum-subarray-with-required-sum_696460

public class MinimumSubarraywithTargetSum 
{
	public static ArrayList<Integer> minSubarray(ArrayList<Integer> arr, int n, int x) 
	{
		// Write your code here
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = n+1;
		int startIndex= 0;

		while(end<n)
		{
			sum += arr.get(end);
			while(sum>x)
			{
				int len = end-start+1;
				if(len<min)
				{
					startIndex = start;
					min = len;
				}
				sum -= arr.get(start);
				start++;
			}
			end++;
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();

		// IF no such subarray exist, return empty subarray
		if (min == n + 1) 
		{
			return ans;
		}

		for (int i = startIndex; i < startIndex + min; i++) 
		{
			ans.add(arr.get(i));
		}

		return ans;
	}
}
