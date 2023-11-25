package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

public class NumPairDivisibleBy60 {
	public int numPairsDivisibleBy60(int[] time) {
		Map<Integer,Integer> map = new HashMap<>();
		int count =0;
		for(int i : time)
		{
			int rem = i%60;
			int req = (60-rem)%60;
			count += map.getOrDefault(req , 0);
			map.put(rem , map.getOrDefault(rem , 0)+1);
		} 

		return count;
	}
}