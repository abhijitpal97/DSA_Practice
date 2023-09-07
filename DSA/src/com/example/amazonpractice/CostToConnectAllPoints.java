package com.example.amazonpractice;

import java.util.*;

class PointsTuple
{
	int[] src;
	int index;
	int cost;

	PointsTuple(int[] src , int index , int cost)
	{
		this.src = src;
		this.index = index;
		this.cost = cost;
	}
}

public class CostToConnectAllPoints {
	public int minCostConnectPoints(int[][] points) {
		Queue<PointsTuple> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		int ans = 0;
		int n = points.length;
		boolean[] isVisited = new boolean[n];
		queue.offer(new PointsTuple(points[0] , 0 , 0));

		while(! queue.isEmpty())
		{
			PointsTuple tp = queue.poll();
			int[] src = tp.src;
			if(isVisited[tp.index]) continue;
			isVisited[tp.index] = true;
			ans += tp.cost;

			for(int i = 0 ; i<points.length ; i++)
			{
				if(tp.index != i && !isVisited[i])
				{
					queue.offer(new PointsTuple(points[i] , i , calculateDistance(src , points[i])));
				}
			}
		}

		return ans;
	}

	int calculateDistance(int[] src , int[] dest)
	{
		return Math.abs(src[0]-dest[0])+Math.abs(src[1] - dest[1]);
	}
}