package com.example.googlepractice;

public class distinctSubsequence {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(s.equals(t)) return 1;
        if(n<m) return 0;
        Integer dp[][]=new Integer[n+1][m+1];
        return function(s,t,0 , 0 , dp);        
    }

    int function(String s , String t , int index1 , int index2 , Integer[][] dp)
    {
        if(index2 == t.length()) return 1;
        if(index1 == s.length()) return 0;

        if(dp[index1][index2] != null) return dp[index1][index2];   
        int take = 0;
        if(s.charAt(index1) == t.charAt(index2))
        {
            take = function(s , t , index1+1 , index2+1 , dp);
        }
        int notTake = function(s , t , index1+1 , index2 , dp);
        
        return dp[index1][index2] = take+notTake;
    }
}