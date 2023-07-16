package com.example.olapractice;

import java.util.*;

public class AllAncesterNodeGraph {

	public static void main(String[] args)
	{
		List<List<Integer>> res = getAncestors(8, new int[][] {{0,3},{0,4},{1,3},
			{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}});
		System.out.println(res);
	}

	public static List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) adj.add(new ArrayList<>());
		int[] inDegree = new int[n];
		Map<Integer,Set<Integer>> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			inDegree[edge[1]]++;
		}

		for(int i=0;i<n;i++)
		{
			if(inDegree[i] == 0)
			{
				queue.offer(i);
				map.put(i , new HashSet<>());
			}
		}

		while(!queue.isEmpty())
		{
			int curr = queue.poll();

			for(int ad : adj.get(curr))
			{
				inDegree[ad]--;
				if(map.containsKey(ad))
				{
					Set<Integer> list = map.get(curr);
					map.get(ad).add(curr);
					if(! list.isEmpty()) map.get(ad).addAll(list);
				}
				else 
				{
					Set<Integer> list = new HashSet<>(Arrays.asList(curr));
					map.put(ad , list);
					if(map.containsKey(curr))
					{
						Set<Integer> newList = map.get(curr);
						map.get(ad).addAll(newList);
					}

				}
				if(inDegree[ad] == 0) queue.offer(ad);
			}
		}

		System.out.println(map);

		List<List<Integer>> result = new ArrayList<>();

		for(Map.Entry<Integer,Set<Integer>> m1 : map.entrySet())
		{
			result.add(new ArrayList<>(m1.getValue()));
		}

		return result;
	}
}