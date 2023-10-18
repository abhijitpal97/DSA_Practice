package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/distant-barcodes/

class RearrangePair
{
	int val;
	int count;

	RearrangePair(int val , int count)
	{
		this.val = val;
		this.count = count;
	}
}

public class RearrangeBarcode {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int n = barcodes.length;
		int index = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : barcodes) map.put(i , map.getOrDefault(i , 0)+1);

		Queue<RearrangePair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);

		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			pq.offer(new RearrangePair(m1.getKey() , m1.getValue()));
		}

		RearrangePair prev = null;
		for(int i=0;i<n;i++)
		{
			RearrangePair curr = pq.poll();
			barcodes[i] = curr.val;
			curr.count--;

			if(prev != null) pq.offer(prev);

			if(curr.count >0) prev = curr;
			else prev = null;
		}

		return barcodes;
	}
}