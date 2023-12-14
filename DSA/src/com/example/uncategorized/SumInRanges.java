package com.example.uncategorized;
import java.util.*;

// https://www.codingninjas.com/studio/problems/sum-of-infinite-array_873335

public class SumInRanges {
	static int mod = 1000000007;
	public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

		// Write your code here!
		List<Integer> list = new ArrayList<>();

		for(List<Long> range : queries)
		{
			long l = range.get(0)-1;
			long r = range.get(1)-1;

			long sum = 0;

			for(long i=l ;i<=r ;i++)
			{
				int index = (int)i%n;
				sum = (sum+arr[index])%mod;
			}

			list.add((int)sum);
		}

		return list;

	}
}