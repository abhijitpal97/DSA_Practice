package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

public class ReorderRoutes {
	public int minReorder(int n, int[][] connections) {
		List<List<Integer>> adj = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;i++) adj.add(new ArrayList<>());

		for(int[] edge : connections)
		{
			int src = edge[0];
			int dest = edge[1];
			adj.get(src).add(dest);
			adj.get(dest).add(src);

			set.add(src+"-"+dest);
		}

		boolean[] isVisited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		queue.offer(0);
		isVisited[0]=true;

		while(! queue.isEmpty())
		{
			int curr = queue.poll();
			for(int i : adj.get(curr))
			{
				if(isVisited[i]) continue;

				isVisited[i] = true;
				if(set.contains(curr+"-"+i)) count++;
				queue.offer(i);

			}
		}

		return count;
	}
}