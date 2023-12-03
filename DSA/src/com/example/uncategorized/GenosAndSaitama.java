package com.example.uncategorized;
import java.util.*;

// https://www.codingninjas.com/studio/problems/genos-and-saitama_2180773

public class GenosAndSaitama 
{
	public static int getMinDistance(int V, int E, int[] a, int[] b, int g, int s)
	{
		// Write your code here.
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0 ; i<V; i++) adj.add(new ArrayList<>());
		boolean[] isVisited = new boolean[V];

		for(int i=0;i<a.length;i++)
		{
			adj.get(a[i]).add(b[i]);
			adj.get(b[i]).add(a[i]);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{g , 0});
		isVisited[g] = true;

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				if(curr[0] == s) return curr[1];

				for(int c : adj.get(curr[0]))
				{
					if(!isVisited[c])
					{
						queue.offer(new int[]{c , curr[1]+1});
						isVisited[c] = true;
					}
				}
			}
		}

		return -1;
	}
}
