package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/k-closest-points-to-origin/
class ClosestPointOriginPair
{
	int[] nums;
	int dist;

	ClosestPointOriginPair(int[] nums , int dist)
	{
		this.nums=nums;
		this.dist = dist;
	}
}

public class KClosestPointToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		Queue<ClosestPointOriginPair> queue = new PriorityQueue<>((a,b) -> a.dist - b.dist);

		for(int i=0;i<points.length;i++)
		{
			queue.offer(new ClosestPointOriginPair(points[i] , getDist(points[i])));
		}

		int[][] res = new int[k][2];

		int index=0;
		while(! queue.isEmpty() && k>0)
		{
			ClosestPointOriginPair p1 = queue.poll();
			res[index][0] = p1.nums[0];
			res[index][1] = p1.nums[1];
			index++;
			k--;
		}

		while(k>0)
		{
			res[index][0] = -1;
			res[index][1] = -1;
			index++;
			k--;
		}

		return res;
	}

	int getDist(int[] points)
	{

		return (points[0] * points[0]) + ((points[1] * points[1]));
	}
}