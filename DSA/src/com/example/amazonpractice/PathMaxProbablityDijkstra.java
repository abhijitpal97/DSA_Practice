package com.example.amazonpractice;

import java.util.*;

class MaxPathPair
{
	int index;
	double prob;

	MaxPathPair(int index , double prob)
	{
		this.index=index;
		this.prob=prob;
	}
}


public class PathMaxProbablityDijkstra {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		List<List<MaxPathPair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) adj.add(new ArrayList<>());

		for(int i = 0 ; i<edges.length ; i++)
		{
			adj.get(edges[i][0]).add(new MaxPathPair(edges[i][1] , succProb[i]));
			adj.get(edges[i][1]).add(new MaxPathPair(edges[i][0] , succProb[i]));
		}

		Queue<MaxPathPair> queue = new LinkedList<>();
		double[] probablity = new double[n];
		Arrays.fill(probablity , 0);
		queue.offer(new MaxPathPair(start_node,1));
		probablity[start_node] = 1;
		while(! queue.isEmpty())
		{
			MaxPathPair p1 = queue.poll();
			int index = p1.index;
			double prob = p1.prob;
			for(MaxPathPair p2 : adj.get(index))
			{
				int currI = p2.index;
				double currP = p2.prob;

				if(prob*currP>probablity[currI])
				{
					probablity[currI] = prob*currP;
					queue.offer(new MaxPathPair(currI , probablity[currI]));
				}
			}
		}

		return probablity[end_node]; 
	}
}