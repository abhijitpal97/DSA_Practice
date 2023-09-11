package com.example.amazonpractice;

import java.util.*;

class FlightPair
{
	int dest;
	int cost;

	FlightPair(int dest , int cost)
	{
		this.dest = dest;
		this.cost = cost;
	}
}

class FlightTuple
{
	int dest;
	int cost;
	int stops;

	FlightTuple (int dest , int cost , int stops)
	{
		this.dest = dest;
		this.cost = cost;
		this.stops = stops;
	}
}



public class CheapestFlightKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		List<List<FlightPair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) adj.add(new ArrayList<>());

		for(int[] flight : flights)
		{
			adj.get(flight[0]).add(new FlightPair(flight[1] , flight[2]));
		}

		Queue<FlightTuple> queue = new LinkedList<>();
		int[] dist = new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		queue.offer(new FlightTuple(src,0,0));
		dist[src] = 0;
		while(! queue.isEmpty())
		{
			FlightTuple tp = queue.poll();
			int dest = tp.dest;
			int cost = tp.cost;
			int stop = tp.stops;

			if(stop>k) continue;

			for(FlightPair p1 : adj.get(dest))
			{
				int currD = p1.dest;
				int currC = p1.cost;

				if(cost+currC<dist[currD])
				{
					dist[currD] = cost+currC;
					queue.offer(new FlightTuple(currD,  dist[currD] , stop+1));
				}

			}
		}

		return dist[dst] == Integer.MAX_VALUE?-1:dist[dst];
	}
}