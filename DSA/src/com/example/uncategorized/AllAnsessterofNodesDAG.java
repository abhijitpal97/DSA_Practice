package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/

public class AllAnsessterofNodesDAG {

	public static void main(String[] args)
	{
		List<List<Integer>> res = getAncestors(8, 
				new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}});

		System.out.println(res);
	}

	public static List<List<Integer>> getAncestors(int n, int[][] edges) {
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int i=0;i<edges.length;i++)
		{
			add(graph , edges[i][1] , edges[i][0]);
		}

		List<List<Integer>> answer = new ArrayList<>();
		for(int i = 0;i<n;i++)
		{
			Set<Integer> set = new HashSet<>();
			List<Integer> list = new ArrayList<>();
			dfs(i , graph , set , list,i);
			Collections.sort(list);
			answer.add(list);
		}

		return answer;
	}

	static void dfs(int curr , Map<Integer,List<Integer>> graph , Set<Integer> set , List<Integer> list , int src)
	{
		set.add(curr);
		if(curr != src) list.add(curr);
		if(! graph.containsKey(curr)) return;
		List<Integer> neighbours = graph.get(curr);
		for(int i : neighbours)
		{
			if(! set.contains(i))
			{
				dfs(i , graph , set , list , src);
			}
		}
	}

	static void add(Map<Integer,List<Integer>> map , int u , int v)
	{
		if(map.containsKey(u)) map.get(u).add(v);
		else
		{
			List<Integer> list = new ArrayList<>();
			list.add(v);
			map.put(u , list);
		}
	}
}