package com.example.uncategorized;

import java.util.*;

public class TripletSumLessThanK
{
	long countTriplets(long arr[], int n,int sum)
	{
		Arrays.sort(arr);
		long count = 0;

		for(int i = 0 ; i<n-2 ; i++)
		{
			int low = i+1;
			int high = n-1;

			while(low<high)
			{
				long curr = arr[i]+arr[low]+arr[high];
				if(curr < sum )
				{
					count += high-low;
					low++;
				}
				else high--;
			}
		}

		return count;
	}
}