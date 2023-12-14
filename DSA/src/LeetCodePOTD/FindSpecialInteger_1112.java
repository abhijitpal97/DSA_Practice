package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

public class FindSpecialInteger_1112 {
	public int findSpecialInteger(int[] arr) {
		int n = arr.length;
		int count = n/4;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			int x = arr[i];
			map.put(x , map.getOrDefault(x , 0)+1);

			if(map.get(x) > count) return x;
		}
		return -1;
	}
}