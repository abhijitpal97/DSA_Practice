package com.example.amazonpractice;

public class FindRedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n+1];
		for(int i=0;i<=n;i++)
		{
			parent[i] = i;
		}

		for(int[] edge : edges)
		{
			int a = find(edge[0] , parent);
			int b = find(edge[1] , parent);
			if(a==b) return edge;

			union(a,b,parent);
		}

		return new int[]{-1,-1};
	}

	void union(int a ,int b, int[] parent)
	{
		int x = find(a , parent);
		int y = find(b , parent);

		if(x != y) parent[y] = x;
	}

	int find(int a , int[] parent)
	{
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a] , parent);
	}
}