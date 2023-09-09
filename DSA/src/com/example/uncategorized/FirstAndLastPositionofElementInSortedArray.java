package com.example.uncategorized;

import java.util.*;

public class FirstAndLastPositionofElementInSortedArray
{
	ArrayList<Integer> find(int arr[], int n, int x)
	{
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		list.add(findFirst(arr,n,x));
		list.add(findLast(arr,n,x));

		return list;
	}

	int findFirst(int[] arr , int n , int x)
	{
		int start = 0;
		int end = n-1;
		int res = -1;

		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(arr[mid]>=x) end = mid-1;
			else start = mid+1;

			if(arr[mid] == x) res = mid;
		}

		return res;
	}

	int findLast(int[] arr , int n , int x)
	{
		int start = 0;
		int end = n-1;
		int res = -1;

		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(arr[mid]<=x) start = mid+1;
			else end = mid-1;

			if(arr[mid] == x) res = mid;
		}

		return res;
	}
}