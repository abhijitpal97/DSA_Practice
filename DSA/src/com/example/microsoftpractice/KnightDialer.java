package com.example.microsoftpractice;

public class KnightDialer {
    int mod=(int)1e9+7;
    public int knightDialer(int n) {
        int result = 0 ;
        if(n<1) return 0;
        if(n==1) return 10;
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int[][] dirs = new int[][]{{1,2},{-1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1}};
        Long[][][] dp = new Long[5][4][n];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(matrix[i][j] != -1)  result= (int)(result+dfs(i , j , matrix , dirs , n-1 , dp))%mod;
            }
        }

        return result%mod;
    }

    long dfs(int r , int c , int[][] matrix , int[][] dirs , int steps , Long[][][] dp)
    {
        long ans =0;
        if(steps == 0) return 1;
        if(dp[r][c][steps] != null) return dp[r][c][steps];

        for(int[] dir: dirs)
        {
            int cR = r+dir[0];
            int cC = c+dir[1];

            if(cR>=0 && cR<4 && cC>=0 && cC<3 && matrix[cR][cC] != -1)
            {
                ans = (ans+dfs(cR,cC,matrix,dirs,steps-1,dp))%mod;
            }
        }

        return dp[r][c][steps] = ans;
    }
}