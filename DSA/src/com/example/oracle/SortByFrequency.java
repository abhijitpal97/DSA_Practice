package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/sort-array-by-increasing-frequency
public class SortByFrequency {
	public int[] frequencySort(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();

		for(int i : nums) map.put(i,map.getOrDefault(i,0)+1);

		List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list , new Comparator<Map.Entry<Integer,Integer>>()
		{
			public int compare(Map.Entry<Integer,Integer> o1 , Map.Entry<Integer,Integer> o2)
			{
				int x = o1.getValue();
				int y = o2.getValue();
				if(x==y) return o2.getKey().compareTo(o1.getKey());
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		int index = 0;
		for(Map.Entry<Integer,Integer> m1 : list)
		{
			int value = m1.getValue();
			while(value != 0)
			{
				nums[index] = m1.getKey();
				index++;
				value--;
			}
		}

		return nums;
	}
}