package com.example.apple;

import java.util.*;

public class SumOfOddSumPermutation {
	static int MOD = 1000000007;
	static int count =0;
	static Set<Integer> set;
	public static void main(String[] args)
	{
		numOfSubarrays(new int[] {1,2,3,4,5,6,7});
		System.out.println(set);
		System.out.println(count);
	}

	public static int numOfSubarrays(int[] arr) {
		set = new HashSet<>();
		count =0;
		function(arr,arr.length , 0 , 0 , new ArrayList<>());
		return count%MOD;
	}

	static void function(int[] arr , int n , int index , int sum,List<Integer> list)
	{

		if(index>=n)
		{
			System.out.println(list+ " -sum - "+sum);
			if(sum%2 == 1 && set.add(sum)) {
				count = (count+1)%MOD;
			}
			return;
		}

		list.add(arr[index]);
		function(arr , n , index+1 , sum+arr[index],list);
		list.remove(list.size()-1);
		function(arr, n , index+1 , sum,list);
	}
}