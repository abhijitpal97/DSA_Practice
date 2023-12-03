package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/


class CityConnectionPair{
	int node;
	int dis;
	CityConnectionPair(int node, int dis){
		this.node = node;
		this.dis = dis;
	}
}


public class FindCityMaxConnection {

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		List<List<CityConnectionPair>> adjList = new ArrayList<>(); 
		for(int i = 0; i<n; i++)
			adjList.add(new ArrayList<>());

		for(int[] edge: edges){

			adjList.get(edge[0]).add(new CityConnectionPair(edge[1], edge[2]));
			adjList.get(edge[1]).add(new CityConnectionPair(edge[0], edge[2]));
		}

		PriorityQueue<CityConnectionPair> pq = new PriorityQueue<>((x,y) -> x.dis - y.dis); 
		int city = 0;
		int cntmax = n;

		for(int i = 0; i<n; i++)
		{

			int[] dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			pq.add(new CityConnectionPair(i, 0));
			dist[i] = 0;


			while(!pq.isEmpty())
			{
				CityConnectionPair curnode = pq.poll();
				int getval = curnode.node;
				int getdis = curnode.dis;
				for(CityConnectionPair neighbour: adjList.get(getval))
				{
					int newdis = getdis + neighbour.dis;
					if(newdis <= distanceThreshold && newdis < dist[neighbour.node])
					{
						pq.add(new CityConnectionPair(neighbour.node, newdis));
						dist[neighbour.node] = newdis;
					}
				}
			}



			int cnt = 0;
			for(int j = 0; j<n; j++)
			{
				if(dist[j] != Integer.MAX_VALUE)
				{
					cnt++;
				}
			}
			if(cnt <= cntmax)
			{
				city = Math.max(city,i);
				cntmax = cnt;
			}
		}  

		return city;
	}
}