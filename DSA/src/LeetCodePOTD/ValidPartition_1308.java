package LeetCodePOTD;

import java.util.*;

public class ValidPartition_1308 {
	public boolean validPartition(int[] nums) {
		Map<Integer,Boolean> dp = new HashMap<>();
		return function(nums , 0 , dp);
	}

	public boolean  function(int[] nums , int index, Map<Integer,Boolean> dp)
	{
		if(index>=nums.length) return true;
		if(dp.containsKey(index)) return dp.get(index);
		dp.put(index,true);
		boolean two = isEqual(nums,index, index+2) && function(nums , index+2,dp);
		if(two) return true;
		boolean three = isEqual(nums,index, index+3) && function(nums , index+3,dp);
		if(three) return true;
		boolean part = increasing(nums,index, index+3) && function(nums , index+3,dp);
		if(part) return true;

		dp.put(index,false);
		return false;

	}

	public boolean isEqual(int[] nums, int start , int end)
	{
		if(nums.length<end) return false;
		int index= start;

		while(start<end)
		{
			if(nums[start] != nums[index] ) return false;
			start++;
		}
		return true;
	}

	public boolean increasing(int[] nums , int start , int end)
	{
		int pre = nums[start];

		if(nums.length<end) return false;
		start++;
		while(start<end)
		{
			if(nums[start] != pre+1) return false;
			pre = nums[start];
			start++;
		}

		return true;
	}


}