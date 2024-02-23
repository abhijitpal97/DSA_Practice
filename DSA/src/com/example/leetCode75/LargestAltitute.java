package com.example.leetCode75;

// https://leetcode.com/problems/find-the-highest-altitude/description/

public class LargestAltitute {
	public int largestAltitude(int[] gain) {
		int n = gain.length;
		int[] alt = new int[n+1];
		int max = 0;
		alt[0] = 0;

		for(int i=0;i<n;i++)
		{
			alt[i+1] = alt[i]+gain[i];
			max = Math.max(max , alt[i+1]);
		}

		return max;
	}
}