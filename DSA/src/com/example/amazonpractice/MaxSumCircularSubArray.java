package com.example.amazonpractice;

// https://leetcode.com/problems/maximum-sum-circular-subarray/description/

public class MaxSumCircularSubArray {
	public int maxSubarraySumCircular(int[] nums) {
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE; //5
		for(int i =0; i<n ; i++)
		{
			maxSum = Math.max(maxSum , kadanesAlgo(i , nums , n));
		}
		return maxSum;
	}
	// 0 -> 7
	// 1 -> 7
	int kadanesAlgo(int index , int[] nums , int n)
	{
		int sumTillNow = nums[index]; // 5
		int maxSum = nums[index]; // 5
		for(int i =0; i<n-1 ; i++)
		{
			index++; // 3 4
			int curr = index%n; // 0 1
			sumTillNow = Math.max(sumTillNow+nums[curr] , nums[curr]); // 10 7
			maxSum = Math.max(maxSum , sumTillNow); // 10
		}
		return maxSum;
	}

	// O(n) - Single Pass with max min value
	public int maxSubarraySumCircularSinglePass(int[] nums) {
		int n = nums.length;
		int sumTillNow = nums[0]; // 5
		int sumTillNowM = nums[0];
		int maxSum = nums[0]; // 5
		int minSum = nums[0];
		int total = nums[0];
		for(int i =1; i<n ; i++)
		{
			total += nums[i];

			sumTillNow = Math.max(sumTillNow+nums[i] , nums[i]); // 10 7
			maxSum = Math.max(maxSum , sumTillNow); // 10


			sumTillNowM = Math.min(sumTillNowM+nums[i] , nums[i]); // 10 7
			minSum = Math.min(minSum , sumTillNowM); // 10
		}

		if(maxSum <0) return maxSum;

		int circular = total - minSum;

		return Math.max(maxSum , circular);
	}
}