package LeetCodePOTD;

import java.util.*;

public class MinOperationToRequceValueFromFrontOrRear_2009 {
	int min = Integer.MAX_VALUE;
	public int minOperations(int[] nums, int x) {
		min = Integer.MAX_VALUE;
		function(nums , 0 , nums.length-1 , x , 0);
		return min==Integer.MAX_VALUE?-1:min;
	}

	void function(int[] nums , int startIndex , int endIndex , int x , int count)
	{
		if(x==0)
		{
			min = Math.min(min , count);
			return;
		}
		if(x<0) return;
		if(startIndex>endIndex) return;

		function(nums , startIndex+1 , endIndex , x-nums[startIndex] , count+1);
		function(nums , startIndex , endIndex-1 , x-nums[endIndex] , count+1);
	}

	// Two Pointer - Prefix Sum Approach
	public int minOperationsTwoPointers(int[] nums, int x) {
		int totalSum = 0;
		for (int n : nums) {
			totalSum += n;
		}

		int target = totalSum - x;

		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int currSum = 0;
		int max = -1;

		for(int i = 0 ; i<nums.length ;i++)
		{
			currSum = currSum+nums[i];
			map.put(currSum , i);

			if(map.containsKey(currSum-target))
			{
				max = Math.max(max , i-map.get(currSum-target));
			}
		}

		return max == -1 ? max:nums.length-max;
	}

}