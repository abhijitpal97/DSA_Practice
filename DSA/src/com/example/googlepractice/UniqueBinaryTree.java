package com.example.googlepractice;

public class UniqueBinaryTree {
	
    public int numTrees(int n) {
        if(n==1) return 1;

        Integer[][] dp = new Integer[n+1][n+1];

        return calculate(n , 1 , dp);
    }

    int calculate(int n , int curr , Integer[][] dp)
    {
        if(curr>n) return 1;

        if(dp[n][curr] != null) return dp[n][curr];

        int count =0;

        for(int i=curr;i<=n;i++)
        {
            int left = calculate(i-1 , curr , dp);
            int right = calculate(n , i+1 , dp);

            count += left * right;
        }

        return dp[n][curr] = count;
    }
}