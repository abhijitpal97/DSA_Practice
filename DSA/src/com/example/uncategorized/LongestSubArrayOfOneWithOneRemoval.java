package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

public class LongestSubArrayOfOneWithOneRemoval {
	public static void main(String[] args)
	{
		int res = longestSubarray(new int[] {1,1,0,1});
		System.out.println(res);
	}
	public static int longestSubarray(int[] nums) {
		int start = 0;
		Queue<Integer> queue = new LinkedList<>();
		int counter = 1;
		int max = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i] == 0)
			{
				if(counter == 1)
				{
					counter--;
				}
				else
				{
					max = Math.max(max , queue.size());
					if(queue.isEmpty()) start = i;
					else
					{
						while(nums[start] != 0)
						{
							start++;
							queue.poll();
						}
						start++;
					}
				}
			}
			else if(nums[i] == 1) queue.offer(i);
		}
		max = Math.max(max,queue.size());
		if(max == nums.length) max--;
		return max;
	}
}