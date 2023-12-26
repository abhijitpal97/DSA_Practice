package com.example.apple;

import java.util.*;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

public class GroupOfPeople {
	public static void main(String[] args)
	{
		List<List<Integer>> res = groupThePeople(new int[]{3,3,3,3,3,1,3});
		System.out.println(res);
	}
	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer , List<Integer>> map = new HashMap<>();

		for(int i=0; i<groupSizes.length ; i++)
		{
			List<Integer> temp = map.getOrDefault(groupSizes[i] , new ArrayList<>());
			map.put(groupSizes[i] , temp);
			temp.add(i);

			if(temp.size() == groupSizes[i])
			{
				list.add(new ArrayList<>(temp));
				map.put(groupSizes[i] , new ArrayList<>());
			}
		}

		return list;
	}
}