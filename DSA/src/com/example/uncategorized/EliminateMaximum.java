package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/

public class EliminateMaximum {
	public int eliminateMaximum(int[] dist, int[] speed) {
		Queue<Double> pq = new PriorityQueue<>();

		for(int i=0; i<dist.length; i++)
		{
			pq.offer((double) dist[i]/speed[i]);
		}

		int ans = 0;

		while(! pq.isEmpty())
		{
			if(pq.poll() <= ans) break;

			ans++;
		}

		return ans;
	}
}