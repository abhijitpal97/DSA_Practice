package com.example.amazonpractice;

import java.util.*;

public class PossibleBipartition
{
	public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
	{
		// Code here
		int[] color  = new int[V];

		for(int i = 0; i< V;i++)
		{
			if(color[i] == 0)
			{
				if(! check(i , color , adj , V)) return false;
			}
		}

		return true;
	}

	boolean check(int src , int[] color , ArrayList<ArrayList<Integer>> adj , int V)
	{
		color[src] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);

		while(! queue.isEmpty())
		{
			int curr = queue.poll();

			for(int i : adj.get(curr))
			{
				if(color[i] == 0)
				{
					if(color[curr] == 1) color[i] = 2;
					if(color[curr] == 2) color[i] = 1;
					queue.offer(i);
				}
				else if(color[curr] == color[i]) return false;
			}
		}

		return true;
	}
}