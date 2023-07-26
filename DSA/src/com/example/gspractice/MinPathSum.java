package com.example.gspractice;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Integer[][] dp = new Integer[row+1][col+1];
        return dfs(grid , 0 , 0 , row-1 ,col-1 , row , col , dp);
    }

    public int dfs(int[][] grid ,int srcR , int srcC , int destR , int destC , int row , int col , Integer[][] dp)
    {
        if(srcR==destR && srcC == destC) return grid[srcR][srcC];
        if(srcR>=row || srcC>=col) return (int)1e7;
        if(dp[srcR][srcC] != null) return dp[srcR][srcC];
        int r = grid[srcR][srcC]  + dfs(grid , srcR , srcC+1 , destR , destC , row , col , dp);
        int d = grid[srcR][srcC]  + dfs(grid , srcR+1 , srcC , destR , destC , row , col , dp);

        return dp[srcR][srcC] = Math.min(r,d);
    }
}