package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/number-of-recent-calls/

public class RecentCounter {
	Queue<Integer> queue;
	public RecentCounter() {
		queue = new LinkedList<>();
	}

	public int ping(int t) {
		queue.offer(t);
		while(queue.peek()<t-3000) queue.poll();

		return queue.size();
	}
}