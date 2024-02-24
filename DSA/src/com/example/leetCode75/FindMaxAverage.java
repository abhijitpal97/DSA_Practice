package com.example.leetCode75;

// https://leetcode.com/problems/maximum-average-subarray-i/

public class FindMaxAverage {
	public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		int n = nums.length;
		for(int i = 0 ; i<k ; i++) sum += nums[i];

		double avg = (double) sum/k;

		int start = 0;
		int end = k;

		while(end<n)
		{
			sum +=nums[end];
			sum -=nums[start];
			start++;
			end++;

			avg = Math.max(avg , ((double) sum/k));
		} 

		return avg;
	}
}