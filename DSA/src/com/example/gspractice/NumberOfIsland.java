package com.example.gspractice;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] isVisited = new boolean[row][col];

        int count = 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == '1' && ! isVisited[i][j])
                {
                    dfs(grid , i , j , row , col,isVisited);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid , int r , int c , int row , int col , boolean[][] isVisited)
    {
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c] =='0' || isVisited[r][c]) return;

        isVisited[r][c] = true;

        dfs(grid , r+1 , c , row , col , isVisited);
        dfs(grid , r-1 , c , row , col , isVisited);
        dfs(grid , r , c+1 , row , col , isVisited);
        dfs(grid , r , c-1 , row , col , isVisited);
    }
}