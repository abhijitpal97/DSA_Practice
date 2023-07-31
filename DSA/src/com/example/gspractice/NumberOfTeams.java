package com.example.gspractice;

public class NumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        Integer[][][] dp = new Integer[n][n+1][4];
        Integer[][][] dp1 = new Integer[n][n+1][4];
        int inc = functionInc(rating , -1 , 0 , 3 , dp);
        int dec = functionDec(rating , -1 , 0 , 3 , dp1);

        return inc+dec;
    }

    int functionInc(int[] rating , int prev , int index , int count ,Integer[][][] dp)
    {
        if(count == 0) return 1;
        if(index == rating.length){
            return 0;
        }

        if(dp[index][prev+1][count] != null) return dp[index][prev+1][count];
        int pick = 0;
        if(prev == -1 || rating[index]>rating[prev]) pick = functionInc(rating ,index , index+1 , count-1 , dp);
        int notPick = functionInc(rating , prev , index+1 , count , dp);
        return dp[index][prev+1][count] = pick+notPick;
    }

    int functionDec(int[] rating , int prev , int index , int count ,Integer[][][] dp)
    {
        if(count == 0) return 1;
        if(index == rating.length){
            return 0;
        }
        if(dp[index][prev+1][count] != null) return dp[index][prev+1][count];
        int pick = 0;
        if(prev == -1 || rating[index]<rating[prev]) pick = functionDec(rating ,index , index+1 , count-1 , dp);
        int notPick = functionDec(rating , prev , index+1 , count , dp);
        return dp[index][prev+1][count] = pick+notPick;
    }

    
}