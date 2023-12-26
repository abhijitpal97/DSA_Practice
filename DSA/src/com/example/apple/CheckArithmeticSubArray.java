package com.example.apple;

import java.util.*;

// https://leetcode.com/problems/arithmetic-subarrays

public class CheckArithmeticSubArray {
	public static void main(String[] args)
	{
		List<Boolean> res = checkArithmeticSubarrays(new int[] {4,6,5,9,3,7},
				new int[] {0,0,2}, new int[] {2,3,5});
		System.out.println(res);
	}
	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> list = new ArrayList<>();

		for(int i = 0;i<l.length;i++)
		{
			int[] subArray = Arrays.copyOfRange(nums , l[i] , r[i]+1);
			list.add(check(subArray));
		}
		return list;
	}

	static boolean check(int[] arr)
	{
		Arrays.sort(arr);

		int diff = arr[1]-arr[0];

		for(int i = 2 ; i<arr.length ; i++)
		{
			if(arr[i] - arr[i-1] != diff) return false;
		}
		return true;

	}
}