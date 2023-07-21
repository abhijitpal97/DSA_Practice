package com.example.microsoftpractice;

public class MinChangeToTransformWordAddDeleteUpdate {
    public int minDistance(String word1, String word2) {
         int n1 = word1.length();
        int n2 = word2.length();
        Integer[][] dp = new Integer[n1][n2];

        return calculateLIS(word1,word2,n1-1,n2-1,dp);
    }


    int calculateLIS(String word1 , String word2 , int n1 , int n2 , Integer[][] dp)
    {
        if(n1 < 0) return n2+1;
        if(n2 < 0) return n1+1;

        if(dp[n1][n2] != null) return dp[n1][n2];

        if(word1.charAt(0) == word2.charAt(0))
        {
            return dp[n1][n2] = calculateLIS(word1.substring(1),word2.substring(1),n1-1,n2-1 , dp);
        }
        else
        {
            int l=calculateLIS(word1.substring(1),word2,n1-1,n2 , dp);
            int r=calculateLIS(word1,word2.substring(1),n1,n2-1 , dp);
            int m = calculateLIS(word1.substring(1),word2.substring(1),n1-1,n2-1 , dp);
            return dp[n1][n2] = 1+ Math.min(l , Math.min(r,m));
        }

        
    }
}