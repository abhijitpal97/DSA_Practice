package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/first-missing-positive/description/

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		Set<Integer> set = new TreeSet<>();
		for(int i : nums)
		{
			if(i>0) set.add(i);
		}

		int missing = 1;

		for(int i : set)
		{
			if(i == missing) missing++;
			else return missing;
		}
		return missing;
	}
}