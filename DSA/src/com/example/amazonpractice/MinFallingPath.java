package com.example.amazonpractice;

public class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Integer[][] dp = new Integer[r][c];
        int min = (int)1e9;
        for(int i=0;i<c;i++)
        {
            min = Math.min(min , dfs(0 , i , r , c ,matrix, dp));
        }

        return min==(int)1e9?0:min;
    }

    int dfs(int r , int c , int row , int col , int[][] matrix , Integer[][] dp)
    {
        if(c<0 || c>=col) return (int)1e9;
        if(r == row-1) return matrix[r][c];
        
        if(dp[r][c] != null) return dp[r][c];

        int down = matrix[r][c] +dfs(r+1,c,row,col,matrix , dp);
        int leftdown = matrix[r][c] +dfs(r+1,c-1,row,col,matrix , dp);
        int rightdown = matrix[r][c] +dfs(r+1,c+1,row,col,matrix , dp);

        return dp[r][c] = Math.min(down , Math.min(leftdown , rightdown));
    }
}