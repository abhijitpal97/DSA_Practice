package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/rank-transform-of-an-array/description/

public class RankTransform {
	public int[] arrayRankTransform(int[] arr) {
		int n = arr.length;
		Map<Integer,List<Integer>> map = new TreeMap<>();
		for(int i = 0;i<n;i++)
		{
			if(map.containsKey(arr[i])) map.get(arr[i]).add(i);
			else map.put(arr[i] , new ArrayList<>(Arrays.asList(i)));
		}

		int rank = 1;
		for(Map.Entry<Integer,List<Integer>> m1 : map.entrySet())
		{
			for(int i : m1.getValue())
			{
				arr[i] = rank;
			}
			rank++;
		}

		return arr;
	}
}