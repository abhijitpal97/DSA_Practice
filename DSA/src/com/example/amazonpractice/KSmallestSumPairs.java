package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

class SmallSumTuple
{
	int n1;
	int n2;
	int sum;

	SmallSumTuple(int n1 , int n2 , int sum)
	{
		this.n1 = n1;
		this.n2 = n2;
		this.sum = sum;
	}
}



public class KSmallestSumPairs {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Queue<SmallSumTuple> pq = new PriorityQueue<>((a,b) -> a.sum - b.sum);

		for(int i =0;i<nums1.length;i++)
		{
			for(int j=0;j<nums2.length;j++)
			{
				pq.offer(new SmallSumTuple(nums1[i] , nums2[j] , nums1[i]+nums2[j]));
			}
		}

		List<List<Integer>> result= new ArrayList<>();

		while(!pq.isEmpty() && k>0)
		{
			SmallSumTuple tp = pq.poll();
			result.add(Arrays.asList(tp.n1,tp.n2));
			k--;
		}

		return result;
	}
}