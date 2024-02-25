package com.example.amazonpractice;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/description/
// leetCode75

public class RemoveMinimumOverlappingInterval {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals , (a,b) -> a[0]-b[0]);

		int last = intervals[0][1];
		int count =0;
		for(int i = 1; i<intervals.length ; i++)
		{
			if(intervals[i][0] <last) 
			{
				count++;
				if(last>intervals[i][1]) last = intervals[i][1];
			}
			else last = intervals[i][1];
		}

		return count;
	}
}