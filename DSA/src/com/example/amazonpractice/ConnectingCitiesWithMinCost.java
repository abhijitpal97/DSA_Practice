package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/connecting-cities-with-minimum-cost_1386586

class CityPair
{
	int dest;
	int cost;

	CityPair(int dest , int cost)
	{
		this.dest = dest;
		this.cost = cost;
	}
}


public class ConnectingCitiesWithMinCost {

	public static int getMinimumCost(int n, int m, int[][] connections) {
		// Write your code here.
		List<List<CityPair>> adj = new ArrayList<>();
		for(int i=0 ; i<=n ;i++) adj.add(new ArrayList<>());
		for(int[] con : connections)
		{
			adj.get(con[0]).add(new CityPair(con[1] , con[2]));
			adj.get(con[1]).add(new CityPair(con[0] , con[2]));
		}

		boolean[] isVisited = new boolean[n+1];
		isVisited[0] = true;
		int sum = 0;
		Queue<CityPair> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		queue.offer(new CityPair(1,0));

		while(! queue.isEmpty())
		{
			CityPair p1 = queue.poll();
			if(isVisited[p1.dest])  continue;
			isVisited[p1.dest] = true;

			sum += p1.cost;
			for(CityPair p2 : adj.get(p1.dest))
			{
				int currD = p2.dest;
				if(! isVisited[currD])  queue.offer(new CityPair(currD  , p2.cost));
			}
		}

		for(int i =0 ;i<=n; i++) 
		{
			if(! isVisited[i]) return -1;
		}

		return sum;
	}

}