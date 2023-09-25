package com.example.amazonpractice;

import java.util.*;


// https://leetcode.com/problems/find-eventual-safe-states/description/

public class EventualSafeState {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<List<Integer>> adj = new ArrayList<>();
		int n= graph.length;
		int[] inDegree = new int[n];

		for(int i=0; i<n ; i++) adj.add(new ArrayList<>());

		for(int i =0;i<n;i++)
		{
			for(int gr : graph[i])
			{
				adj.get(gr).add(i);
				inDegree[i]++;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<n ; i++)
		{
			if(inDegree[i] == 0) 
			{
				queue.offer(i);
				list.add(i);
			}
		}

		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i = 0 ; i<size; i++)
			{
				int curr = queue.poll();
				for(int cu : adj.get(curr))
				{
					inDegree[cu]--;
					if(inDegree[cu] == 0)
					{
						queue.offer(cu);
						list.add(cu);
					}
				}
			}
		}

		Collections.sort(list);
		return list;


	}
}