package com.example.googlepractice;

import java.util.*;

// https://leetcode.com/problems/maximum-width-ramp/description/

public class MaxWidthRamp {
	public int maxWidthRamp(int[] nums) {

		// {{2,8} , {0,6} , {5,5} , {3,2} , {4,1} , {1,0}}
		Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		for(int i=0; i<nums.length; i++) pq.offer(new int[]{i , nums[i]});

		int ans = 0;

		for(int i=nums.length-1 ; i>=0 ; i--)
		{
			while(! pq.isEmpty() && pq.peek()[1] <=nums[i])
			{
				ans = Math.max(ans , i-pq.poll()[0]);
			}
		}
		return ans;
	}
}