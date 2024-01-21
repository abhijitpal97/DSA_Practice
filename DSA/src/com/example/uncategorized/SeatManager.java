package com.example.uncategorized;

import java.util.*;	

// https://leetcode.com/problems/seat-reservation-manager/

public class SeatManager {
	Queue<Integer> pq;
	Set<Integer> set;
	public SeatManager(int n) {
		pq = new PriorityQueue<>();
		set = new HashSet<>();
		for(int i=1;i<=n;i++) pq.offer(i);
	}

	public int reserve() {
		if(pq.isEmpty()) return -1;

		int curr = pq.poll();
		set.add(curr);
		return curr; 
	}

	public void unreserve(int seatNumber) {
		if(set.remove(seatNumber)) pq.offer(seatNumber);
	}
}