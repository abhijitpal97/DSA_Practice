package com.example.uncategorized;

public class PartitionArrayTwoArraysMinSum {
    static int min = Integer.MAX_VALUE;
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        min = Integer.MAX_VALUE;
		int total = 0;
		for(int i : nums) total += i;
		function(nums , n , 0 , total , 0,0);
		return min;
    }

    
	static void function(int[] arr , int n , int sum1 , int sum2 , int index, int count)
	{
		if(index>= n) return;

		if(count == n/2)
		{
			min = Math.min(min , Math.abs(sum1 - sum2));
			return;
		}

		function(arr , n , sum1+arr[index] , sum2-arr[index] , index+1 , count+1);
		function(arr , n , sum1 , sum2 , index+1,count);
	}
}