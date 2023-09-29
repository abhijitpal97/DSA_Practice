package LeetCodePOTD;

// https://leetcode.com/problems/monotonic-array/description/

public class MonotonicArray_2909 {
	public boolean isMonotonic(int[] nums) {
		return isIncreasing(nums) || isDecresing(nums);
	}

	boolean isIncreasing(int[] nums)
	{
		int prev = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]>=prev)
			{
				prev = nums[i];
			}
			else return false;
		}
		return true;
	}

	boolean isDecresing(int[] nums)
	{
		int prev = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]<=prev)
			{
				prev = nums[i];
			}
			else return false;
		}
		return true;
	}
}