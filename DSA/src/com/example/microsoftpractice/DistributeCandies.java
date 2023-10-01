package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/distribute-candies/description/

public class DistributeCandies {
	public static void main(String[] args)
	{
		Map<Integer, Integer> map = distributeCandiesExt(new int[] {1,1,1,2,2,2,2,3,3,3});
		System.out.println(map);
	}
	public static int distributeCandies(int[] candyType) {
		int total = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : candyType)
		{
			total++;
			map.put(i , map.getOrDefault(i,0)+1);
		}
		int eligible = total/2;
		return Math.min(map.size() , eligible);
	}

	// Extended Version - Which Type How Many
	public static Map<Integer, Integer> distributeCandiesExt(int[] candyType) {
		int total = 0;
		Map<Integer,Integer> map = new HashMap<>();
		Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
		Queue<int[]> queue = new LinkedList<>();
		for(int i : candyType)
		{
			total++;
			map.put(i , map.getOrDefault(i,0)+1);
		}
		int eligible = total/2;

		for(Map.Entry<Integer, Integer> m1 : map.entrySet())
		{
			pq.offer(new int[] {m1.getKey() , m1.getValue()});
		}
		map.clear();
		while(eligible != 0)
		{
			int[] curr = pq.poll();
			map.put(curr[0], map.getOrDefault(curr[0], 0)+1);
			if(curr[1] >0) queue.offer(curr);
			eligible--;
			if(eligible == 0) break;
			if(pq.isEmpty())
			{
				while(! queue.isEmpty()) pq.offer(queue.poll());
			}
		}

		return map;
	}
}