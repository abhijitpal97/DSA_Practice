package com.example.microsoftpractice;

import java.util.*;

class TupleKSmallest
{
	int a;
	int b;
	int sum;

	public TupleKSmallest(int a , int b , int sum)
	{
		this.a=a;
		this.b=b;
		this.sum=sum;
	}
}


public class KSmallestPairSum {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Queue<TupleKSmallest> pq = new PriorityQueue<>((a , b) -> a.sum - b.sum);
		for(int i : nums1)
		{
			for(int j:nums2) pq.offer(new TupleKSmallest(i , j , i+j));
		}

		List<List<Integer>> result = new ArrayList<>();

		while(! pq.isEmpty() && k>0)
		{
			TupleKSmallest tp = pq.poll();
			result.add(new ArrayList<>(Arrays.asList(tp.a , tp.b)));
			k--;
		}

		return result;

	}
}