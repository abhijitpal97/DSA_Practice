package com.example.amazonpractice;

// https://leetcode.com/problems/jump-game-iii/description/

public class JumpGame3 {
	public boolean canReach(int[] arr, int start) {
		return function(arr , start , arr.length,new boolean[arr.length]);
	}

	boolean function(int[] arr , int index , int n , boolean[] dp)
	{
		if(index<0 || index>=n) return false;
		if(arr[index] == 0) return true;
		if(dp[index] == true) return false;

		dp[index] = true;
		boolean left = function(arr,index-arr[index] , n , dp);
		boolean right = function(arr,index+arr[index] , n , dp);

		return left || right ; 
	}
}