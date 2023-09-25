package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

public class AllPossibleReceipes {
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		HashSet<String> sup = new HashSet<>();
		HashMap<String, Integer> index = new HashMap<>();
		HashMap<String, List<String>> map = new HashMap<>();
		int[] indegree = new int[recipes.length];

		for(String s: supplies) {
			sup.add(s);
		}

		for(int i = 0; i < recipes.length; i++) {
			index.put(recipes[i], i);
		}

		for(int i = 0; i < recipes.length; i++) {
			for(String need: ingredients.get(i)) {
				if(sup.contains(need))
					continue;

				map.putIfAbsent(need, new ArrayList<String>());
				map.get(need).add(recipes[i]);
				indegree[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < recipes.length; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}

		List<String> cooked = new ArrayList<>();
		while(! queue.isEmpty())
		{
			int curr = queue.poll();
			cooked.add(recipes[curr]);

			if(! map.containsKey(recipes[curr])) continue;

			for(String str : map.get(recipes[curr]))
			{
				int i = index.get(str);
				indegree[i]--;

				if(indegree[i] == 0) queue.offer(i);
			}
		}

		return cooked;
	}
}