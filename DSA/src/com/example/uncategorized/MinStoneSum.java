package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/remove-stones-to-minimize-the-total/

public class MinStoneSum {
	public static void main(String[] args)
	{
		int res = minStoneSum(new int[] {5,4,9}, 2);
		System.out.println(res);
	}
	public static int minStoneSum(int[] piles, int k) {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0 ; i<piles.length; i++) pq.offer(piles[i]);

		while(!pq.isEmpty() && k != 0)
		{
			int curr = pq.poll();
			curr = curr - (int)Math.floor(curr/2);
			if(curr != 0) pq.offer(curr);
			k--;
		}
		int count = 0;
		while(! pq.isEmpty())
		{
			count += pq.poll();
		}

		return count;
	}
}