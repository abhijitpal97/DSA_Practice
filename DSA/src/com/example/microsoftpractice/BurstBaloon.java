package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/burst-balloons/description/

public class BurstBaloon {
	int max = Integer.MIN_VALUE;
	public int maxCoins(int[] nums) {
		max = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<>();
		for(int i : nums) list.add(i);

		burst(list , 0);
		return max;
	}

	void burst(List<Integer> list , int curr)
	{
		if(list.isEmpty())
		{
			max = Math.max(curr , max);
			return;
		}

		if(list.size() == 1)
		{
			int temp = list.get(0);
			list.remove(0);
			burst(list , curr+temp);
			list.add(0,temp);
			return;
		}

		for(int i=0;i<list.size();i++)
		{
			int prod = 1;
			if(i==0) prod = list.get(i)*list.get(i+1);
			else if(i==list.size()-1) prod = list.get(i-1)*list.get(i);
			else prod = list.get(i-1)*list.get(i)*list.get(i+1);

			int temp = list.get(i);
			list.remove(i);
			burst(list , curr+prod);
			list.add(i , temp);
		}
	}


	// Memorization

	class Solution {
		public int maxCoins(int[] nums) {
			int[] numsNew = new int[nums.length + 2];
			numsNew[0] = numsNew[nums.length + 1] = 1;
			for (int i = 0; i < nums.length; i++) {
				numsNew[i + 1] = nums[i];
			}
			Integer[][] dp = new Integer[numsNew.length + 1][numsNew.length + 1];

			return burst(numsNew, 1, numsNew.length - 1, dp);

		}

		int burst(int[] p , int i , int j , Integer[][] dp)
		{
			if (i == j) {
				return 0;
			}
			if (dp[i][j] != null) {
				return dp[i][j];
			}
			dp[i][j] = Integer.MIN_VALUE;
			for (int k = i; k < j; k++) {
				dp[i][j] = Math.max(dp[i][j],
						burst(p, i, k, dp) + burst(p, k + 1, j, dp) + p[i - 1] * p[k] * p[j]);
			}
			return dp[i][j];
		}
	}
}