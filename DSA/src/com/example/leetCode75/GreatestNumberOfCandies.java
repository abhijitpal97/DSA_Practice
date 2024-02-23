package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

public class GreatestNumberOfCandies {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0;
		int n = candies.length;

		for(int i=0 ; i<n ; i++) max = Math.max(candies[i] , max);

		List<Boolean> result = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			if(candies[i]+extraCandies >= max) result.add(true);
			else result.add(false);
		}

		return result;
	}
}