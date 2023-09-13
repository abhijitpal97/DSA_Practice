package com.example.amazonpractice;

import java.util.*;

public class LargestDivisibleSubset {
	static int max = Integer.MIN_VALUE;
	static List<Integer> result;

	public static void main(String[] args)
	{
		largestDivisibleSubset(new int[] {5,9,18,54,108,540,90,180,360,720});
		System.out.println(result);
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		max = Integer.MIN_VALUE;
		result = new ArrayList<>();
		function(nums , 0 , -1 , 0 , new ArrayList<>() , nums.length);
		return result;
	}

	static void  function(int[] nums , int index , int prev , int count ,  List<Integer> list , int n)
	{
		if(index == n)
		{
			if(count>max)
			{
				result.clear();
				for(int i : list) result.add(i);
				max = count;
			}
			return;
		}

		if(prev == -1 || (nums[index]%prev == 0) || (prev%nums[index] == 0))
		{
			list.add(nums[index]);
			function(nums , index+1 , nums[index] , count+1 , list , n);
			list.remove(list.size()-1);
		}

		function(nums , index+1 , prev , count , list , n);
	}
}