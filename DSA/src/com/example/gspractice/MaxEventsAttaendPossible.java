package com.example.gspractice;

import java.util.*;

// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
//Google

public class MaxEventsAttaendPossible {
	public int maxEvents(int[][] events) {
		Arrays.sort(events , (a , b) -> a[0] - b[0]);

		int day = 0 ;
		int index = 0;
		int n = events.length;
		int count = 0;
		Queue<Integer> pq = new PriorityQueue<>();

		while(! pq.isEmpty() || index<n)
		{
			if(pq.isEmpty())
			{
				day = events[index][0];
			}

			while(index<n && events[index][0] <= day)
			{
				pq.offer(events[index][1]);
				index++;
			}
			day++;
			pq.poll();
			count++;

			while(! pq.isEmpty() && pq.peek()<day) pq.poll();
		}

		return count;
	}
}