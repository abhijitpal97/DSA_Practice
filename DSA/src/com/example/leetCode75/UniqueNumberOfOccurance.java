package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/unique-number-of-occurrences/

public class UniqueNumberOfOccurance {
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : arr) map.put(i , map.getOrDefault(i , 0)+1);

		Set<Integer> set = new HashSet<>();
		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			if(! set.add(m1.getValue())) return false;
		}
		return true;
	}
}