package com.example.olapractice;


public class PerfectSum{

	public static void main(String[] args)
	{
		int res = perfectSum(new int[] {2, 3, 5, 6, 8, 10}, 6, 10);
		System.out.println(res);
	}
	
	public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    Integer[][] dp = new Integer[n][sum+1];
	    return function(sum , n-1 , arr , dp);
	} 
	
	static int function(int target , int index , int[] arr , Integer[][] dp)
	{
	    if(target == 0) return 1;
	    if(target<0) return 0;
	    if(index<0) return 0;
	    
	    if(dp[index][target] != null) return dp[index][target];
	    int pick = function(target-arr[index] , index-1 , arr , dp);
	    int notPick = function(target , index-1 , arr , dp);
	    
	    return dp[index][target] = pick+notPick;
	}
}