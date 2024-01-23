package com.example.uncategorized;

import java.util.*;

// https://www.geeksforgeeks.org/problems/smallest-subarray-with-all-occurrences-of-a-most-frequent-element2258/1

public class SmallestSegment{

	public static void main(String[] args)
	{
		ArrayList<Integer> res = smallestSubsegment(new int[] {5,7}, 2);
		System.out.println(res);
	}

	static ArrayList<Integer> smallestSubsegment(int a[], int n)
	{
		// Complete the function
		Map<Integer,int[]> map = new LinkedHashMap<>();
		for(int i=0;i<n;i++)
		{
			int c = a[i];
			if(map.containsKey(c))
			{
				int[] curr = map.get(c);
				curr[0]++;
				curr[2] = i;
				map.put(c , curr);
			}
			else map.put(c , new int[]{1,i,i});
		}

		Queue<int[]> pq = new PriorityQueue<>((x,y) -> y[1]-x[1]);

		for(Map.Entry<Integer,int[]> m1 : map.entrySet())
		{
			int[] curr = m1.getValue();
			pq.offer(new int[]{m1.getKey() , curr[0],curr[1],curr[2]});
		}

		List<Integer> list = new ArrayList<>();
		int max = pq.peek()[1];

		while(! pq.isEmpty() && pq.peek()[1] == max)
		{
			list.add(pq.poll()[0]);
		}

		int min = Integer.MAX_VALUE;
		int nums = -1;
		for(int i : list)
		{
			int[] curr = map.get(i);
			int len = curr[2]-curr[1]+1;

			if(len<min)
			{
				min = len;
				nums = i;
			}
		}

		int[] curr = map.get(nums);

		ArrayList<Integer> res = new ArrayList<>();
		for(int i = curr[1]; i<=curr[2] ; i++) res.add(a[i]);

		return res;
	}
}

