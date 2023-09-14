package com.example.amazonpractice;

public class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		for(int i =0;i<n-2;i++)
		{
			if(function(nums , nums[i] , n , i+1 , 2)) return true;
		}

		return false;
	}

	boolean function(int[] nums , int prev , int n , int index , int remaining)
	{
		if(remaining == 0) return true;
		if(index>=n) return false;

		boolean pick = false;
		if(nums[index]>prev) pick = function(nums , nums[index] , n , index+1 , remaining-1);
		if(pick == true) return true;
		boolean notPick = function(nums , prev , n , index+1 , remaining);

		return pick || notPick;
	}

	// 2 Pointer - Single Iteration

	public boolean increasingTripletOnePass(int[] nums) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for(int i : nums)
		{
			if(i<first) first = i;
			else if(i<second) second = i;
			else return true;
		}
		return false;
	}

}