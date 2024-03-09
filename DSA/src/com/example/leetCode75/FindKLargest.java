package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class FindKLargest {
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
		for(int i : nums) pq.offer(i);

		while(!pq.isEmpty() && k != 0)
		{
			int curr = pq.poll();
			k--;
			if(k == 0) return curr;
		}

		return -1;
	}
}