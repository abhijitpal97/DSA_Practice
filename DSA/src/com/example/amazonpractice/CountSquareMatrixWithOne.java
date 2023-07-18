package com.example.amazonpractice;

public class CountSquareMatrixWithOne {
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];

        for(int i = 0;i<c;i++) dp[0][i] = matrix[0][i];
        for(int j=0;j<r;j++) dp[j][0] = matrix[j][0];

        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                if(matrix[i][j] == 1) dp[i][j] = 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));
            }
        }

        int ans = 0;
        for(int i = 0 ; i<r ; i++)
        {
            for(int j=0;j<c;j++)
            {
                ans +=dp[i][j];
            }
        }

        return ans;
    }
}