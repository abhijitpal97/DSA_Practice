package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
// ZScaler

public class FindSmallestSetOfVertices {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		int[] inDegree = new int[n];
		List<Integer> list = new ArrayList<>();

		for(List<Integer> edge : edges)
		{
			int dest = edge.get(1);

			inDegree[dest]++;
		}

		for(int i=0;i<n;i++)
		{
			if(inDegree[i] == 0) list.add(i);
		}

		return list;
	}
}