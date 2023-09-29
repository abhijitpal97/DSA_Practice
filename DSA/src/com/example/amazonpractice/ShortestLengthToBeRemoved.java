package com.example.amazonpractice;

// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

public class ShortestLengthToBeRemoved {
	public int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length;
		int i = 0;
		int j = n-1;

		while(i<n-1 && arr[i]<=arr[i+1]) i++;
		if(i == n-1) return 0;
		while(j>0 && arr[j-1]<=arr[j]) j--;
		if(j == 0) return 0;

		int ans = Math.min(n-i-1 , j);
		int t = i;
		i = 0;
		while(i<=t && j<n)
		{
			if(arr[i]<=arr[j]) i++;
			else j++;

			ans = Math.min(ans , j-i);
		}

		return ans;
	}
}