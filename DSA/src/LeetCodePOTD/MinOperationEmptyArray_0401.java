package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/

public class MinOperationEmptyArray_0401 {
	public int minOperations(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : nums) map.put(i , map.getOrDefault(i , 0)+1);

		int count = 0;
		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			int val = m1.getValue();
			if(val == 1) return -1;
			if(val%3==1 || val%3==2) count++;
			count += val/3;
		}

		return count;
	}
}