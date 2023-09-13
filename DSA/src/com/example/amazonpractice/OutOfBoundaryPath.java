package com.example.amazonpractice;

public class OutOfBoundaryPath {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];

        return function(startRow,startColumn,m,n,maxMove,0,dp);
    }

    int function(int r , int c , int row , int col , int maxMove , int curr , Integer[][][] dp)
    {
        if(curr>maxMove) return 0;
        if(r<0 || r>=row || c<0 || c>= col) return 1;

        if(dp[r][c][curr] != null) return dp[r][c][curr];

        int s = 0;

        s = (s+function(r+1,c,row,col,maxMove,curr+1,dp))%1000000007;
        s = (s+function(r-1,c,row,col,maxMove,curr+1,dp))%1000000007;
        s = (s+function(r,c+1,row,col,maxMove,curr+1,dp))%1000000007;
        s = (s+function(r,c-1,row,col,maxMove,curr+1,dp))%1000000007;

        return dp[r][c][curr] = s;
    }
}