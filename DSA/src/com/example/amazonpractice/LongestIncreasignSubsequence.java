package com.example.amazonpractice;

// https://leetcode.com/problems/longest-increasing-subsequence/description/

public class LongestIncreasignSubsequence {
    
	public static void main(String[] args)
	{
		int res = lengthOfLIS(new int[] {1,3,5,4,7});
		System.out.println(res);
	}
	
    public static  int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        
        return longestSearch(nums , 0 , nums.length , -1 , dp);
        
    }

    static int longestSearch(int[] nums , int index , int n, int prev , Integer[][] dp)
    {
        if(index>=n) return 0;
        if(dp[index][prev+1] != null) return dp[index][prev+1];

        int notskip=0;
        if(prev == -1 || nums[index] > nums[prev] ) notskip = 1+longestSearch(nums , index+1 , n , index, dp);
        int skip = longestSearch(nums , index+1 , n , prev , dp);

        return dp[index][prev+1] = Math.max(skip , notskip);
        
    }


    

}