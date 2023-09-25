package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/

public class MinimumHeightTree {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> adj = new ArrayList<>();
		if(n <= 1){
			list.add(0);

			return list;
		}
		Queue<Integer> queue = new LinkedList<>();
		int[] indegree = new int[n];
		for(int i=0; i<n;i++) adj.add(new ArrayList<>());

		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
			indegree[edge[0]]++;
			indegree[edge[1]]++;
		}

		for(int i=0;i<n;i++)
		{
			if(indegree[i] == 1) queue.offer(i);
		}

		while(! queue.isEmpty())
		{
			int size = queue.size();
			list.clear();
			for(int i=0;i<size;i++)
			{
				int curr = queue.poll();
				list.add(curr);
				for(int ed: adj.get(curr))
				{
					indegree[ed]--;
					if(indegree[ed] == 1) queue.offer(ed);
				}
			}
		}

		return list;
	}
}