package com.example.uncategorized;
import java.util.*;

class PairUndirectedGraph
{
	int index;
	int level;

	public PairUndirectedGraph(int index , int level)
	{
		this.index = index;
		this.level = level;
	}
}
public class ShortestPathUnweightedGraph {

	public static void main(String[] args)
	{
		LinkedList<Integer> res= shortestPath(new int[][] {{4,4},{1,4},{1,2},{2,3},{3,4}} , 4 , 4 , 1 , 3);
		System.out.println(res);
	}

	public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
		// Write your code here.
		boolean[] isVisited = new boolean[n+1];
		Queue<PairUndirectedGraph> queue = new LinkedList<>();
		int[] parent = new int[n+1];
		queue.offer(new PairUndirectedGraph(s , 0));
		isVisited[s] = true;
		parent[s] = -1;

		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

		for(int[]edge : edges)
		{
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		Map<Integer,Integer> map = new HashMap<>();
		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				PairUndirectedGraph curr = queue.poll();
				if(t == curr.index) return tracePath(curr.index, parent);
				for(int nei : adj.get(curr.index))
				{
					if(!isVisited[nei])
					{
						queue.offer(new PairUndirectedGraph(nei ,curr.level+1 ));
						isVisited[nei] = true;
						parent[nei] = curr.index;
					}
				}
			}
		}

		return new LinkedList<>();

	}

	static LinkedList<Integer> tracePath(int target , int[] parent)
	{
		LinkedList<Integer> list = new LinkedList<>();
		while(true)
		{
			//System.out.println(target + " - " +parent[target]);
			if(target == -1) break;
			list.add(0 , target);
			target = parent[target];
		}
		System.out.println(list);
		return list;
	}

}