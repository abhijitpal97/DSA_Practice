package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsicutiveSubsequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int longest = 0;

		for(int i : nums) set.add(i);

		for(int curr : set)
		{
			int count =1;
			if(! set.contains(curr-1))
			{
				while(set.contains(curr+1))
				{
					count++;
					curr++;
				}
			}

			longest = Math.max(longest , count);
		}

		return longest;
	}
}