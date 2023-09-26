package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/critical-connections-in-a-network/description/

public class CriticalConnection {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i<connections.size();i++)
		{
			List<Integer> li = connections.get(i);
			connections.remove(i);
			boolean res = calculate(n , connections);
			if(! res) list.add(new ArrayList<>(li));
			connections.add(i , li);
		}

		return list;
	}

	boolean calculate(int n , List<List<Integer>> connections)
	{
		int[] parent = new int[n];
		for(int i=0 ; i<n ; i++) parent[i] = i;

		for(List<Integer> li : connections)
		{
			union(li.get(0),li.get(1),parent);
		}

		int count = 0;
		for(int i=0; i<n;i++)
		{
			if(i == parent[i]) count++;
		}

		return count==1;
	}

	int find(int a  , int[] parent)
	{
		if(a == parent[a]) return a;
		return find(parent[a] , parent);
	}

	void union(int a , int b , int[] parent)
	{
		int x = find(a,parent);
		int y = find(b,parent);

		if(x==y) return;
		else parent[y] = x;
	}
}