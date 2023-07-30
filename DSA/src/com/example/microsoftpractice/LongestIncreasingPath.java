package com.example.microsoftpractice;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxLength = 0 ;
        Integer[][] dp = new Integer[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j = 0;j<col;j++)
            {
                boolean[][] isVisited = new boolean[row][col];
                maxLength = Math.max(maxLength , dfs(i , j , row , col , isVisited , dp , matrix , Integer.MIN_VALUE));
            }
        }

        return maxLength; 
    }

    int dfs(int r , int c , int row , int col , boolean[][] isVisited , Integer[][] dp , int[][] matrix , int prev)
    {
        boolean isSafe = isSafe(r , c , row , col , matrix , prev,isVisited);
        int result = 0;
        if(isSafe)
        {
            if(dp[r][c] != null) return dp[r][c];
            isVisited[r][c] = true;
            int le = dfs(r , c-1,row,col, isVisited , dp , matrix , matrix[r][c]);
            int ri = dfs(r , c+1,row,col, isVisited , dp , matrix , matrix[r][c]);
            int up = dfs(r-1 , c,row,col, isVisited , dp , matrix , matrix[r][c]);
            int dow = dfs(r+1 , c,row,col, isVisited , dp , matrix , matrix[r][c]);
            isVisited[r][c] = false;

            result = 1+Math.max(le , Math.max(ri , Math.max(up , dow)));
            dp[r][c] = result;
        }

        return result;
    }

    boolean isSafe(int r , int c , int row , int col , int[][] matrix , int prev , boolean[][] isVisited)
    {
        if(r>=0 && r<row && c>=0 && c<col && matrix[r][c]>prev && !isVisited[r][c]) return true;
        else return false;
    }
}