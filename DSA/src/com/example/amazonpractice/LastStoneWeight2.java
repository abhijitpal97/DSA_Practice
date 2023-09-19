package com.example.amazonpractice;

import java.util.*;

public class LastStoneWeight2 {

	public static void main(String[] args)
	{
		int res = lastStoneWeightII(new int[] {31,31});
		System.out.println(res);
	}

	public static int lastStoneWeightII(int[] stones) {
		if(stones.length == 1) return stones[0];

		Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

		for(int i : stones) queue.offer(i);

		while(queue.size() != 1)
		{
			int bigger = queue.poll();
			int smaller = queue.poll();


			if(bigger>smaller) 
			{
				bigger = bigger-smaller;
				queue.offer(bigger);
			}


			if(queue.isEmpty()) return -1;
		}

		return queue.peek();
	}
}