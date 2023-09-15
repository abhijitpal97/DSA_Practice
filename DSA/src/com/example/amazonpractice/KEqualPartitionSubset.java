package com.example.amazonpractice;

public class KEqualPartitionSubset {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int n = nums.length;
		if(n<k) return false;
		if(k == 1) return true;
		int total = 0;

		for(int i : nums) total += i;
		boolean[] isVisited = new boolean[n];
		if(total % k != 0) return false;
		int target = total / k ;
		return function(k , 0 , target , nums , isVisited);

	}

	boolean function(int  k , int curr , int target , int[] nums , boolean[] isVisited)
	{
		if(k == 1) return true;
		if(curr>target) return false;

		if(curr == target) return function(k-1 , 0 , target , nums , isVisited);


		for(int i = 0; i<nums.length ; i++)
		{
			if(! isVisited[i] && curr+nums[i] <= target)
			{
				isVisited[i] = true;
				if(function(k , curr+nums[i] , target, nums , isVisited)) return true;

				isVisited[i] = false;
			}
		}

		return false;

	}
}