package com.example.microsoftpractice;

public class MaxSumPath {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Integer[][] dp = new Integer[row][col];
        return function(0,0,row-1,col-1,row,col,dp,grid);
    }

    int function(int srcR,int srcC , int destR, int destC , int row, int col , Integer[][] dp,int[][] grid)
    {
        if(srcR==destR && srcC==destC) return grid[srcR][srcC];
        if(srcR>= row || srcC>=col) return (int)1e9;
        if(dp[srcR][srcC] != null) return dp[srcR][srcC];

        int d = grid[srcR][srcC] + function(srcR+1,srcC,destR,destC,row,col,dp,grid);
        int r = grid[srcR][srcC] + function(srcR,srcC+1,destR,destC,row,col,dp,grid);

        return dp[srcR][srcC] = Math.min(d,r);
    }
}