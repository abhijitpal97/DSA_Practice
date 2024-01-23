package com.example.uncategorized;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/umbrella_1402895

public class MinUmbrellas {
    public static int minUmbrellas(int[] umbrella, int m)  {
        // Write your code here.
        int n = umbrella.length;
        Integer[][] dp = new Integer[n+1][m+1];
        int ans =  function(umbrella  , m , 0 , n , dp);
        if(ans >= (int)1e9) return -1;
        return ans;
    }

    static int function(int[] umbrella , int m , int index , int n , Integer[][] dp)
    {
        if(m==0) return 0 ;
        if(index >= n) return (int)1e9;

        if(dp[index][m] != null) return dp[index][m];

        int ans = function(umbrella , m , index+1 , n , dp);
        if(m >= umbrella[index]) ans = Math.min(ans , 
        1+function(umbrella , m-umbrella[index] , index+1 , n , dp));

        return dp[index][m] = ans;
    }


}