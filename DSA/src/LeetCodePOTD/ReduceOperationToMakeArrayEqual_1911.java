package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/

public class ReduceOperationToMakeArrayEqual_1911 {
	public int reductionOperations(int[] nums) {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Map<Integer,Integer> map = new HashMap<>();
		int count = 0;
		for(int i : nums)
		{
			if(!pq.contains(i)) pq.offer(i);
			map.put(i , map.getOrDefault(i , 0)+1);
		} 

		if(pq.size() == 1) return count;
		// 1->5
		// 1
		while(pq.size() != 1)
		{
			int first = pq.poll(); // 2
			int second = pq.peek(); // 1
			int currC = map.get(first); //3
			count += currC; // 4
			map.remove(first); 
			map.put(second , map.get(second)+currC);
		}

		return count; 
	}
}