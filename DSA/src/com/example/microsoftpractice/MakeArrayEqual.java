package com.example.microsoftpractice;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/

public class MakeArrayEqual {
	public int minMoves2(int[] nums) {
		int n = nums.length;
		if(n==1) return 0;

		Arrays.sort(nums);
		int med = 0;

		if(n%2 == 0 ) med = (nums[n/2]+nums[n/2 -1])/2;
		else med = nums[n/2];

		int res = 0;

		for(int i : nums) res += Math.abs(i-med);
		return res;
	}
}