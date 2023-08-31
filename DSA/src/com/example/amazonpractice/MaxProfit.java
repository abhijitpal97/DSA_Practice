package com.example.amazonpractice;

import java.util.*;

public class MaxProfit {
	public int maxProfit(int[] inventory, int orders) {
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i : inventory) queue.offer(i);
		int count = 0;
		while(! queue.isEmpty() && orders>0)
		{
			int curr = queue.poll();
			count += curr;
			count = count%1000000007;
			curr -=1;
			if(curr>0) queue.offer(curr);
			orders--;
		}
		return count%1000000007;
	}
}