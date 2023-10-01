package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/

public class MinDifferenceLargestAndSmallestThreeMoves_0908 {
	public int minDifference(int[] nums) {

		if (nums.length < 5) {
			return 0;
		}

		Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder()); // 0 1
		Queue<Integer> max = new PriorityQueue<>(); // 5 10 14

		for(int num : nums)
		{
			if(max.size() > 3)
			{
				max.offer(num);
				min.offer(max.poll());
			}
			else max.offer(num);
		}  

		int result = Integer.MAX_VALUE;
		while(! max.isEmpty())
		{
			result = Math.min(result , max.peek()-min.poll());
			min.offer(max.poll());
		}
		return result;
	}


}