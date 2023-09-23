package com.example.gspractice;

import java.util.*;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/

public class FindPairsWithKDifference {

	public static void main(String[] args)
	{
		int count = findPairs(new int[] {3,1,4,1,5}, 2);
		System.out.println(count);

		count = findPairsTimeOptimized(new int[] {3,1,4,1,5}, 2);
		System.out.println(count);

		count = findPairsTimeOptimized1(new int[] {3,1,4,1,5}, 2);
		System.out.println(count);
	}

	public static int findPairs(int[] nums, int k) {
		List<List<Integer>> result = new ArrayList<>();
		calculation(nums, new ArrayList<>(), result , 0 , Integer.MIN_VALUE,k);
		System.out.println(result);
		return result.size();
	}

	static void calculation(int[] nums , List<Integer> list , List<List<Integer>> result , int index , int prev,int k)
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

	// Time Optimized
	public static int findPairsTimeOptimized(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i<nums.length;i++)
		{
			if(set.contains(nums[i]+k))
			{
				List<Integer> res = new ArrayList<>(new ArrayList<>(Arrays.asList(nums[i] , nums[i]+k)));
				if(!list.contains(res)) list.add(res);
			}
			if(set.contains(nums[i]-k))
			{
				List<Integer> res = new ArrayList<>(new ArrayList<>(Arrays.asList(nums[i]-k , nums[i])));
				if(!list.contains(res)) list.add(res);
			}
			set.add(nums[i]);
		}

		System.out.println(list);
		return list.size();
	}


	//Time 
	public static int findPairsTimeOptimized1(int[] nums, int k) {
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