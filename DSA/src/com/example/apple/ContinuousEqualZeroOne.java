package com.example.apple;

import java.util.*;

public class ContinuousEqualZeroOne {
	public int findMaxLength(int[] nums) {
		for(int i = 0;i<nums.length;i++)
		{
			if(nums[i] == 0) nums[i] = -1;
		}

		int target = 0;
		HashMap<Integer , Integer> map = new HashMap<>();
		map.put(0 , -1);
		int currSum =0;
		int count  = 0;
		for(int i=0;i<nums.length;i++)
		{
			currSum +=nums[i];

			if(map.containsKey(currSum))
			{
				count =Math.max(count , i - map.get(currSum));
			}
			else map.put(currSum , i);
		}

		return count;

	}
}