package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/

class UniqueIntegerPair
{
	int nums;
	int count;

	UniqueIntegerPair(int nums , int count)
	{
		this.nums = nums;
		this.count=count;
	}
}


public class UniqueIntegerKRemoval_1602 {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : arr) map.put(i , map.getOrDefault(i , 0)+1);

		Queue<UniqueIntegerPair> pq = new PriorityQueue<>((a,b) -> a.count-b.count);

		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			pq.offer(new UniqueIntegerPair(m1.getKey() , m1.getValue()));
		}

		while(!pq.isEmpty() && k != 0)
		{
			UniqueIntegerPair p1 = pq.poll();
			int count = p1.count;
			if(count<=k) k -= count;
			else
			{
				pq.offer(new UniqueIntegerPair(p1.nums , count-k));
				k=0;
			}
		}

		return pq.size();
	}
}