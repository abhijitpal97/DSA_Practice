package com.example.googlepractice;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/find-the-median-of-all-subarrays-of-a-particular-size_1229069

public class FindMedianOfArray {

	public static void main(String[] args)
	{
		ArrayList<Double> res = findMedian(new ArrayList<>(Arrays.asList(1,2,3,4,4,3,2,1)), 8, 4);
		System.out.println(res);
	}
	public static ArrayList < Double > findMedian(ArrayList < Integer > arr, int n, int m) {
		// Write your code here.
		ArrayList<Double> result = new ArrayList<>();
		int start = 0;
		int end = m;
		if(m%2==0)
		{
			int first = (end+start)/2;
			int second = first-1;

			while(end<=n)
			{
				int curr = (arr.get(first) + arr.get(second));
				result.add(curr/2.0);
				first++;
				second++;
				start++;
				end++;
			}
		}
		else
		{
			int first = (end+start)/2;

			while(end <= n)
			{
				int curr = arr.get(first);
				result.add((double)curr);
				first++;
				start++;
				end++;
			}
		}

		return result;
	}
}