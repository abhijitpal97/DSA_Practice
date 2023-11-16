package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description

public class MinEleAfterDecAndRearrange_1511 {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		int largest = 1;
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i : arr) pq.offer(i);

		int prev = -1;

		while(! pq.isEmpty())
		{
			int curr = pq.poll();
			if(prev == -1)
			{
				if(curr != 1) curr = 1;
			}
			else
			{
				if(Math.abs(prev-curr)>1) curr = prev+1;
			}
			prev = curr;
			largest = Math.max(largest , prev);
		}

		return largest;
	}
}