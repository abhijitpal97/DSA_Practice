package com.example.uncategorized;
import java.util.ArrayList;
// https://www.codingninjas.com/studio/problems/n-distinct-integers-with-zero-sum_2179740

public class NDistinctWithSumZero 
{
	public static ArrayList<Integer> distinctZeroSum(int n) 
	{
		// Write your code here
		ArrayList<Integer> result = new ArrayList<>();
		int mid = n/2;
		int nums = 0;
		int sum = 0;
		for(int i = 0 ;i<mid ;i++)
		{
			nums = nums-1;
			sum += nums;
			result.add(nums);
		}
		nums = 0;
		for(int i = mid ;i<n-1 ;i++)
		{
			nums = nums+1;
			sum += nums;
			result.add(nums);
		}

		result.add(0-sum);
		//System.out.println(result);
		return result;
	}   
}