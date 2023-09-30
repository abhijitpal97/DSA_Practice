package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/interval-list-intersections/

public class SortedIntervalIntersections {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int p1 = 0;
		int p2 = 0;
		int n = firstList.length;
		int m = secondList.length;
		List<int[]> result = new ArrayList<>();
		while(p1<n && p2<m)
		{
			int start = Math.max(firstList[p1][0] , secondList[p2][0]);
			int end = Math.min(firstList[p1][1] , secondList[p2][1]);

			if(start<=end)
			{
				result.add(new int[]{start , end});
			} 

			if(firstList[p1][1]<secondList[p2][1]) p1++;
			else if(firstList[p1][1]>secondList[p2][1]) p2++;
			else
			{
				p1++;
				p2++;
			}
		}
		return result.toArray(new int[0][]);        
	}
}