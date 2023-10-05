package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/majority-element-ii/description/

public class MajorityElement2 {
	public List<Integer> majorityElement(int[] nums) {
		int n = nums.length;
		int expect = n/3;

		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
		}

		List<Integer> list = new ArrayList<>();
		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			if(m1.getValue()>expect) list.add(m1.getKey());
		}

		return list;
	}
}