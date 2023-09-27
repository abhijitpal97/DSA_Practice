package com.example.amazonpractice;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

public class LoopInUndirectedGraph {
	static class Graph {
		boolean detectCycle(int V, List<List<Integer>> adj) {
			// Write your code here.
			boolean[] isVisited = new boolean[V];
			for(int i = 0 ;i<V;i++)
			{
				if(!isVisited[i]) 
				{
					if(dfs(i , adj , -1 , isVisited)) return true;
				}
			}
			return false;
		}

		static boolean dfs(int src , List<List<Integer>> adj , int parent , boolean[] isVisited)
		{
			isVisited[src] = true;

			for(int ad : adj.get(src))
			{
				if(! isVisited[ad])
				{
					if(dfs(ad , adj , src , isVisited)) return true;
				}
				else if(ad != parent) return true;
			}

			return false;
		}
	};
}
