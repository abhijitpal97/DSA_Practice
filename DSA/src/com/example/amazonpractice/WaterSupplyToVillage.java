package com.example.amazonpractice;
import java.util.*;


class WaterPair
{
	int pipe;
	int cost;

	WaterPair(int pipe , int cost)
	{
		this.pipe = pipe;
		this.cost = cost;
	}
}

public class WaterSupplyToVillage {

	public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
		// Write your code here
		List<List<WaterPair>> adj = new ArrayList<>();

		for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

		for(int[] pipe : pipes)
		{
			adj.get(pipe[0]).add(new WaterPair(pipe[1] , pipe[2]));
			adj.get(pipe[1]).add(new WaterPair(pipe[0] , pipe[2]));
		}

		for(int i=1;i<=n;i++)
		{
			adj.get(0).add(new WaterPair(i , wells[i-1]));
			adj.get(i).add(new WaterPair(0 , wells[i-1]));
		}

		int sum = 0 ;
		Queue<WaterPair> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		queue.offer(new WaterPair(0,0));
		boolean[] isVisited = new boolean[n+1];

		while(! queue.isEmpty())
		{
			WaterPair p1 = queue.poll();
			if(isVisited[p1.pipe]) continue;
			isVisited[p1.pipe] = true;
			sum += p1.cost;

			for(WaterPair p2 : adj.get(p1.pipe))
			{
				if(! isVisited[p2.pipe])
				{
					queue.offer(new WaterPair(p2.pipe , p2.cost));
				}
			}
		}

		return sum;

	}

}