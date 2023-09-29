package com.example.amazonpractice;

// https://leetcode.com/problems/shortest-path-with-alternating-colors/

import java.util.*;

class Pair
{
	int edge;
	int col;

	Pair(int edge , int col)
	{
		this.edge=edge;
		this.col=col;
	}
}

class AlternateTuple{
	int node;
	int weight;
	int col;
	public AlternateTuple(int node,int weight,int col)
	{
		this.node=node;;
		this.weight=weight;
		this.col=col;
	}
}



public class ShortestAlternatingPaths {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		List<List<Pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) adj.add(new ArrayList<>());

		for(int[] edge : redEdges)
		{
			adj.get(edge[0]).add(new Pair(edge[1] , 0));
		}

		for(int[] edge : blueEdges)
		{
			adj.get(edge[0]).add(new Pair(edge[1] , 1));
		}

		boolean[][] isVisited = new boolean[n][3];
		int[] dist = new int[n];
		Arrays.fill(dist , -1);
		dist[0] = 0;

		Queue<AlternateTuple> queue = new LinkedList<>();
		queue.offer(new AlternateTuple(0,0,2));

		while(! queue.isEmpty())
		{
			AlternateTuple tp = queue.poll();
			int node = tp.node;
			int weight = tp.weight;
			int col = tp.col;

			if(dist[node] == -1 || weight<dist[node]) dist[node] = weight;
			isVisited[node][col] = true;

			for(Pair p1 : adj.get(node))
			{
				int dest = p1.edge;
				int colour = p1.col;

				if(! isVisited[dest][colour] && col != colour)
				{
					queue.offer(new AlternateTuple(dest , weight+1,colour));
				}
			}            
		}

		return dist;
	}
}