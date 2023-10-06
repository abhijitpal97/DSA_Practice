package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/

public class MaxDistancePair {
	// Memory Limit Exceed - 
	//TC - mnlog(mn)
	//SC = mn
	public int maxDistance(int[] nums1, int[] nums2) {
		Queue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);

		for(int i = 0 ; i<nums1.length ; i++)
		{
			for(int j = 0 ; j<nums2.length ; j++)
			{
				if(i<=j && nums1[i]<=nums2[j]) pq.offer(j-i);
			}
		}
		if(pq.isEmpty()) return 0;
		return pq.peek();
	}

	public int maxDistanceOpt(int[] nums1, int[] nums2) {
		int i = 0 ;
		int j = 0 ;
		int n = nums1.length;
		int m = nums2.length;
		int ans = 0;

		while(i<n && j<m)
		{
			if(nums1[i] > nums2[j]) i++;
			else
			{
				ans = Math.max(ans , j-i);
				j++;
			}
		}
		return ans;
	}
}