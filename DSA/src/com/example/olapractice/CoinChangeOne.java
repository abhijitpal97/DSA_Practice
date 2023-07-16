package com.example.olapractice;

import java.util.Arrays;

// User function Template for Java

public class CoinChangeOne {
	
	public static void main(String[] args)
	{
		long res = count(new int[] {1,2,3}, 3, 4);
		System.out.println(res);
	}
    public static long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp = new long[N][sum+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i] , -1);
        
        long ans =  function(coins , N-1 , sum , dp);
        
        return ans;
    }
    
    static long function(int[] coins , int index , int target , long[][] dp)
    {
        if(target == 0) return 1;
        
        if(index < 0)
        {
            //if(target%coins[0] == 0) return 1;
            return 0;
        }
        
        if(dp[index][target] != -1) return dp[index][target];
        
        long notPick = function(coins , index-1 , target , dp);
        long pick = 0;
        if(target>=coins[index]) pick = function(coins , index , target - coins[index] , dp);
        
        return dp[index][target] = pick+notPick;
        
    }
}