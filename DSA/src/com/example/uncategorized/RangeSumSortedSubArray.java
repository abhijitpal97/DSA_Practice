package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

public class RangeSumSortedSubArray {
	public int rangeSum(int[] nums, int n, int left, int right) {
		List<Integer> list = new ArrayList<>();
		int mod = 1000000007;
		for(int i=0;i<n;i++)
		{
			int sum = 0;
			for(int j=i ; j<n;j++)
			{
				sum = (sum + nums[j]) % mod;
				list.add(sum);
			}
		}

		Collections.sort(list);
		int sum = 0;
		for(int i=left-1;i<right;i++)
		{
			sum = (sum + list.get(i))%mod;
		}

		return sum%mod;
	}
}