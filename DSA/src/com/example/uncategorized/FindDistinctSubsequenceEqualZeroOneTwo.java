package com.example.uncategorized;
import java.util.* ;
import java.io.*; 

// Self Practice

public class FindDistinctSubsequenceEqualZeroOneTwo {
	public static int countSubsequence(int n, int[] arr) {
		// Write your code here.
		List<List<Integer>> list = new ArrayList<>();
		function(arr,n, 0 , 0 , 0 , 0 , new ArrayList<Integer>() , list);
		System.out.println(list);
		return list.size()-1;
		

	}

	static void function(int[] arr , int n , int zero , int one , int two ,
	 int index , List<Integer> list , List<List<Integer>> result )
	{
		if(index == n)
		{
			if(zero == one && one == two) 
			{
				if(! result.contains(list)) result.add(new ArrayList<>(list));
			}
			return;
		}

		if(arr[index] == 0) 
		{
			list.add(arr[index]);
			function(arr , n , zero+1 , one , two , index+1 , list , result);
			list.remove(list.size()-1);
		}
		if(arr[index] == 1) 
		{
			list.add(arr[index]);
			function(arr , n , zero , one+1 , two , index+1 , list , result);
			list.remove(list.size()-1);
		}
		if(arr[index] == 2) 
		{
			list.add(arr[index]);
			function(arr , n , zero , one , two+1 , index+1 , list , result);
			list.remove(list.size()-1);
		}

		function(arr , n , zero , one , two , index+1, list , result);
	}
}