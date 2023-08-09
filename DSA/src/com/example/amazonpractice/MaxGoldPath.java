package com.example.amazonpractice;

public class MaxGoldPath {
    int max = Integer.MIN_VALUE;
    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        max = Integer.MIN_VALUE;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] != 0) dfs(i , j , row , col , grid , 0);
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }

    void dfs(int r , int c , int row , int col , int[][] grid , int curr)
    {
        if(r<0 || r>= row || c<0 || c>=col || grid[r][c] == 0)
        {
            max = Math.max(max , curr);
            return;
        } 
        
        int temp = grid[r][c];
        curr = curr+ temp;
        grid[r][c] = 0 ;
        dfs(r , c-1 , row , col , grid , curr);
        dfs(r , c+1 , row , col , grid , curr);
        dfs(r-1 , c , row , col , grid , curr);
        dfs(r+1 , c , row , col , grid , curr);
        grid[r][c] = temp;

    }
}