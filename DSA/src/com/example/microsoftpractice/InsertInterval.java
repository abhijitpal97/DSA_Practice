package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/insert-interval/description/

public class InsertInterval {
	public static void main(String[] args)
	{
		insert(new int[][] {{1,3},{6,9}}, new int[] {2,5});
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<>();

		for(int[] interval : intervals)
		{
			if(interval[1]>=newInterval[0] && newInterval[1]>=interval[0])
			{
				newInterval[0] = Math.min(interval[0] , newInterval[0]);
				newInterval[1] = Math.max(interval[1] , newInterval[1]);
			}
			else
			{
				if(newInterval[1]<interval[0])
				{
					res.add(new int[]{newInterval[0] , newInterval[1]});
					newInterval[0] = interval[0];
					newInterval[1] = interval[1];
				}
				else res.add(new int[]{interval[0] , interval[1]});
			}
		}
		res.add(new int[]{newInterval[0] , newInterval[1]});
		int[][] result = new int[res.size()][2];
		int index = 0;
		for(int[] r  : res)
		{
			result[index] = r;
			index++;
		}
		return result;
	}
}