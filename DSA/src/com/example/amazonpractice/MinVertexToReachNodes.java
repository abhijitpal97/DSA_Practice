package com.example.amazonpractice;

import java.util.*;

public class MinVertexToReachNodes {

	public static void main(String[] args)
	{
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(1,2)));
		list.add(new ArrayList<>(Arrays.asList(3,2)));
		list.add(new ArrayList<>(Arrays.asList(1,3)));
		list.add(new ArrayList<>(Arrays.asList(1,0)));
		list.add(new ArrayList<>(Arrays.asList(0,2)));
		list.add(new ArrayList<>(Arrays.asList(0,3)));

		List<Integer> result = findSmallestSetOfVertices(4, list);
		System.out.println(result);
	}

	public static List<Integer> findSmallestSetOfVertices(int n, 
			List<List<Integer>> edges) {

		int[] parent = new int[n];
		for(int i = 0 ; i <n ; i++) parent[i] = i;

		for(List<Integer> edge : edges)
		{
			int src = edge.get(0) ;
			int dest = edge.get(1);

			int x = find(src , parent);
			int y = find(dest , parent);

			if(y == dest) parent[y] = x;
		}

		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			//System.out.println(parent[i]);
			if(parent[i] == i) list.add(parent[i]);
		}

		return list;

	}

	static int find(int a , int[] parent)
	{
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a] , parent);
	}

}