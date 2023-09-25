package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum/

public class SlidingWindowMax {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int start = 0;
		int end = start+k-1>=n?n-1:start+k-1;
		List<Integer> list = new ArrayList<>();
		while(end<n)
		{
			int curr = Integer.MIN_VALUE;
			for(int i=start;i<=end;i++)
			{
				curr = Math.max(curr,nums[i]);
			}
			start++;
			end++;
			list.add(curr);
		}

		int[] res = new int[list.size()];
		for(int i = 0;i<list.size();i++)
		{
			res[i] = list.get(i);
		}
		return res;
	}

	public int[] maxSlidingWindowTimeOptimization(int[] nums, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		for (int i = 0; i < k; ++i) pq.add(new int[]{nums[i], i});
		int[] ans = new int[nums.length - k + 1];
		ans[0] = pq.peek()[0];
		int j = 1;
		for (int i = k; i < nums.length; ++i) {
			pq.add(new int[]{nums[i], i});
			while (pq.peek()[1] <= i - k)
				pq.poll();
			ans[j++] = pq.peek()[0];
		}
		return ans;
	}
}