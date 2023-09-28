package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/

class NetworkPair
{
	int index;
	int time;

	NetworkPair(int index , int time)
	{
		this.index=index;
		this.time = time;
	}
}

public class NetworKDelayDijkstra {
	public int networkDelayTime(int[][] times, int n, int k) {
		List<List<NetworkPair>> adj = new ArrayList<>();
		for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
		for(int[] time:times)
		{
			adj.get(time[0]).add(new NetworkPair(time[1],time[2]));
		}

		Queue<NetworkPair> queue = new LinkedList<>();
		int[] dist = new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		queue.offer(new NetworkPair(k,0));
		dist[k] = 0;

		while(! queue.isEmpty())
		{
			NetworkPair p1 = queue.poll();
			int index = p1.index;
			int time = p1.time;

			for(NetworkPair p2:adj.get(index))
			{
				int currI = p2.index;
				int currT = p2.time;

				if(time+currT<dist[currI])
				{
					dist[currI] = time+currT;
					queue.offer(new NetworkPair(currI,dist[currI]));
				}
			}
		}

		int time = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++)
		{
			if(dist[i] == Integer.MAX_VALUE) return -1;
			time = Math.max(time, dist[i]);
		}

		return time;
	}
}