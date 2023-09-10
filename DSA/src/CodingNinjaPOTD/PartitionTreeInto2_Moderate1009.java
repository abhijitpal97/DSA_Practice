package CodingNinjaPOTD;

import java.util.ArrayList;

public class PartitionTreeInto2_Moderate1009 {
	public static void main(String[] args)
	{
		int res = perfectPartition(6 , new int[] {95,44,2,86,0,42}, 
				new int[][] {{0,1},{0,3},{1,5},{2,4},{5,2}});
		System.out.println(res);
	}
	public static int perfectPartition(int n, int[] assets, int[][] edges) {
		// Write your code here.

		int len = edges.length;
		int total = 0;
		for(int i : assets) total += i; //150

		int min = Integer.MAX_VALUE;

		for(int i=0;i<len;i++)
		{
			min = Math.min(min , getMin(edges , i , total , n , assets,len));
		}
		return min;
	}

	static int getMin(int[][] edges , int base , int total, int n , int[] assets,int len)
	{
		int[] parent = new int[n]; 
		for(int i =0;i<n;i++) parent[i] = i;

		for(int i=0;i<len;i++)
		{
			if(i != base)
			{
				union(edges[i][0] , edges[i][1] , parent);
			}
		}

		int target = parent[0];
		int curr = 0;
		for(int i = 0 ; i< n ;i++)
		{
			if(parent[i] == target) curr +=assets[i];
		}

		return Math.abs((total-curr) - curr);
	}

	static int find(int a , int[] parent)
	{
		if (a== parent[a]) return a;
		return find(parent[a] , parent);
	}

	static void union(int x , int y , int[] parent)
	{
		int a = find(x,parent);
		int b = find(y,parent);

		if(a==b) return;
		parent[b] = a;
	}


	// Single Iteration - O(n)

	public static int perfectPartitionSimplified(int n, int[] assets, int[][] edges) {
		// Write your code here.

		int total = 0;

		// Iterate 'Assets' to calculate 'total'
		for (int i = 0; i < n; i++) {
			total += assets[i];
		}

		// Adjacency List
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++){
			adj.add(new ArrayList<Integer>());
		}

		// Filling up the adjacency List
		for (int i = 0; i < n - 1; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		int[] ans = new int[1];
		ans[0] = Integer.MAX_VALUE;

		// DFS visited array to keep track of visited nodes
		int[] vis = new int[n];

		// DFS call from 0'th asset
		int val = dfs(0, ans, assets, vis, total, adj);

		// Update 'ans' if required
		ans[0] = Math.min(ans[0], Math.abs(total - val - val));

		return ans[0];
	}

	public static int dfs(int cur, int[] ans, int[] assets, int[] vis, int total, 
			ArrayList<ArrayList<Integer>> adj) {
		vis[cur] = 1;

		// Variable to store sum of subtree rooted at 'cur'
		int subTreeSum = assets[cur];

		ArrayList<Integer> allNodes = adj.get(cur);

		// Iterating child nodes
		for (int i = 0; i < allNodes.size(); i++) {

			int child = allNodes.get(i);

			// Already visited
			if (vis[child] == 1) {
				continue;
			}

			// DFS call on the child node
			int val = dfs(child, ans, assets, vis, total, adj);

			// Update 'ans' if needed
			ans[0] = Math.min(ans[0], Math.abs(total - val - val));

			// Increment the 'subTreeSum' with the value of child subtree
			subTreeSum += val;
		}

		return subTreeSum;
	}

}