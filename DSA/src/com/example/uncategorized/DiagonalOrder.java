package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/diagonal-traverse-ii

public class DiagonalOrder {
	public static void main(String[] args)
	{
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
		list.add(new ArrayList<>(Arrays.asList(6,7)));
		list.add(new ArrayList<>(Arrays.asList(8)));
		list.add(new ArrayList<>(Arrays.asList(9,10,11)));
		list.add(new ArrayList<>(Arrays.asList(12,13,14,15,16)));

		int[] res = findDiagonalOrder(list);
		for(int i : res) System.out.println(i);
	}
	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		int size = 0;
		int max = 0;

		for(int row = nums.size()-1 ; row>=0 ; row--)
		{
			for(int col = 0; col<nums.get(row).size() ; col++)
			{
				int curr = row+col;
				map.putIfAbsent(curr , new ArrayList<>());
				map.get(curr).add(nums.get(row).get(col));

				size++;
				max = Math.max(max , curr);
			}
		}

		int[] res = new int[size];
		int index = 0;

		for(int i = 0; i<=max; i++)
		{
			List<Integer> curr = map.get(i);

			if(curr == null) continue;

			for(int x : curr) res[index++] = x;
		}

		return res;
	}
}