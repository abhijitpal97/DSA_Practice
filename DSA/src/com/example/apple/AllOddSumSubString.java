package com.example.apple;

// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/

public class AllOddSumSubString {
	int MOD = 1000000007;
	int count =0;
	public int numOfSubarrays(int[] arr) {
		count =0;

		for(int i = 0 ; i<arr.length ; i++)
		{
			int sum = 0;
			for(int j = i ; j<arr.length;j++)
			{
				sum += arr[j];
				if(sum %2 == 1) count = (count+1)%MOD;
			}
		}

		return count%MOD;
	}
}