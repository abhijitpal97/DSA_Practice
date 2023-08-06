package com.example.gspractice;

import java.util.*;

public class FindPairsWithKDifference {
	public int findPairs(int[] nums, int k) {
		List<List<Integer>> result = new ArrayList<>();
		calculation(nums, new ArrayList<>(), result , 0 , Integer.MIN_VALUE,k);
		System.out.println(result);
		return result.size();
	}

	void calculation(int[] nums , List<Integer> list , List<List<Integer>> result , int index , int prev,int k)
	{
		if(list.size() == 2)
		{
			List<Integer> temp = new ArrayList<>(list);
			Collections.sort(temp);
			if(! result.contains(temp))result.add(temp);
		}

		if(index>=nums.length) return; 

		if(prev==Integer.MIN_VALUE || Math.abs(prev - nums[index]) == k) 
		{
			list.add(nums[index]);
			calculation(nums , list , result , index+1 , nums[index],k);         
			list.remove(list.size()-1);
		}
		calculation(nums , list , result , index+1 , prev,k);
	}

	//Time 
	public int findPairsTimeOptimized(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		int result = 0;
		for (int i : map.keySet())
			if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
				result++;

		return result;
	}
}