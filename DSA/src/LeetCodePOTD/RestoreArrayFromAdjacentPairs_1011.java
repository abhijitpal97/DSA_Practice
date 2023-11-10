package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/submissions/1095782483/

public class RestoreArrayFromAdjacentPairs_1011 {
	public int[] restoreArray(int[][] adjacentPairs) {
		int n = adjacentPairs.length+1;
		int[] restored = new int[n];

		Map<Integer,List<Integer>> map = new HashMap<>();

		for(int i=0;i<adjacentPairs.length;i++)
		{
			add(map , adjacentPairs[i][0] , adjacentPairs[i][1]);
			add(map , adjacentPairs[i][1] , adjacentPairs[i][0]);
		}

		int start = 0;
		for(int key : map.keySet())
		{
			if(map.get(key).size() == 1)
			{
				start = key;
				break;
			}
		}

		Set<Integer> seen = new HashSet<>();
		List<Integer> answer = new ArrayList<>();
		dfs(start,map,seen,answer);

		for(int i=0;i<answer.size();i++) restored[i] = answer.get(i);

		return restored;
	}

	void add(Map<Integer,List<Integer>> map , int u , int v)
	{
		if(map.containsKey(u)) map.get(u).add(v);
		else
		{
			List<Integer> list = new ArrayList<>();
			list.add(v);
			map.put(u,list);
		}
	}

	void dfs(int src , Map<Integer,List<Integer>> map , Set<Integer> seen , List<Integer> answer)
	{
		answer.add(src);
		seen.add(src);
		List<Integer> neighbours = map.get(src);

		for(int curr : neighbours)
		{
			if(! seen.contains(curr)) dfs(curr , map , seen , answer);
		}
	}
}