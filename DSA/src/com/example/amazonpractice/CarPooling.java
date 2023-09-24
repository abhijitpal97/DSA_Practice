package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/car-pooling/

public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		Arrays.sort(trips , (a , b) -> a[1] - b[1]);
		Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		queue.offer(new int[]{trips[0][0] ,  trips[0][2]});

		capacity -= trips[0][0];
		if(capacity<0) return false;

		for(int i = 1; i<trips.length; i++)
		{
			int[] curr = trips[i];
			while(!queue.isEmpty() && queue.peek()[1] <= curr[1])
			{
				int[] p = queue.poll();
				capacity += p[0];
			}
			queue.offer(new int[]{curr[0] , curr[2]});
			capacity -= curr[0];
			if(capacity < 0) return false;
		}

		return true;
	}
}