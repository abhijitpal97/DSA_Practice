package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/loud-and-rich/

public class LoudAndRich {
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		int n = quiet.length;
		List<List<Integer>> adj = new ArrayList<>();
		int[] inDegree = new int[n];
		for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

		for(int[] rich : richer)
		{
			adj.get(rich[0]).add(rich[1]);
			inDegree[rich[1]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		int[] ans = new int[n];

		for(int i=0; i<n;i++)
		{
			ans[i] = i;
			if(inDegree[i] == 0) queue.offer(i);
		}

		while(! queue.isEmpty())
		{
			int curr = queue.poll();

			for(int i : adj.get(curr))
			{
				if(quiet[ans[i]] > quiet[ans[curr]])
				{
					ans[i] = ans[curr];
				}
				inDegree[i] -- ;
				if(inDegree[i] == 0) queue.offer(i);
			}
		}

		return ans;
	}
}