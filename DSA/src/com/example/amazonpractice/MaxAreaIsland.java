package com.example.amazonpractice;

public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited= new boolean[row][col];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == 1 && !isVisited[i][j])
                {
                    max = Math.max(max , dfs(i , j , row , col , isVisited , grid));
                }
            }
        }

        return max==Integer.MIN_VALUE?0:max;
    }

    int dfs(int r , int c , int row , int col , boolean[][] isVisited , int[][] grid)
    {
        if(r<0 || r>=row || c<0 || c>= col || isVisited[r][c] || grid[r][c] != 1) return 0;
        isVisited[r][c] = true;

        int down = 1+dfs(r+1,c,row,col,isVisited,grid);
        int up = 1+dfs(r-1,c,row,col,isVisited,grid);
        int left = 1+dfs(r,c-1,row,col,isVisited,grid);
        int right = 1+dfs(r,c+1,row,col,isVisited,grid);

        return down+up+left+right-3;
    }
}