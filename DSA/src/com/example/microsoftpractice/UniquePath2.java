package com.example.microsoftpractice;

public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        Integer[][] dp = new Integer[row+1][col+1];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1 ) return 0;
        
        return function(obstacleGrid , 0 , 0 , row-1 , col-1 , row , col , dp);
    }

    int function(int[][] obstacleGrid , int srcR , int srcC , int destR , int destC , int row , int col , Integer[][] dp)
    {
        if(srcR == destR && srcC == destC) return 1;
        if(srcR >=row || srcC>=col || obstacleGrid[srcR][srcC] == 1) return 0;
        if(dp[srcR][srcC] != null) return dp[srcR][srcC];
        int d = function(obstacleGrid , srcR+1 , srcC , destR , destC , row , col , dp);
        int r = function(obstacleGrid , srcR , srcC+1 , destR , destC , row , col , dp);

        return dp[srcR][srcC] = d+r;
    }
}