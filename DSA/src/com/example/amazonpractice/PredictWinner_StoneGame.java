package com.example.amazonpractice;

public class PredictWinner_StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[n][n][2];
        int total = 0;
        for(int i : piles) total +=i;
        int p1 = function(piles , 0 , n-1,0,dp);
        int p2 = total-p1;
        return p1>p2;

    }

    int function(int[] piles , int startIndex , int endIndex , int player , Integer[][][] dp)
    {
        if(startIndex>endIndex) return 0;
        if(startIndex==endIndex) return piles[startIndex];

        if(dp[startIndex][endIndex][player] != null) return dp[startIndex][endIndex][player];

        int pileC = 0;
        if(player==0)
        {
            pileC = Math.max(piles[startIndex] + function(piles , startIndex+1 , endIndex , 1 , dp) , 
            piles[endIndex] + function(piles , startIndex , endIndex-1 , 1 , dp));
        }
        else
        {
            pileC = Math.min(function(piles , startIndex+1 , endIndex , 0 , dp) , 
            function(piles , startIndex , endIndex-1 , 0 , dp));
        }

        return dp[startIndex][endIndex][player] = pileC;
    }
}