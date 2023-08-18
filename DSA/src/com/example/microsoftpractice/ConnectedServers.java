package com.example.microsoftpractice;

public class ConnectedServers {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int system = 0;

        for(int i = 0 ; i<row ; i++)
        {
            for(int j = 0 ; j<col ; j++)
            {
                if(grid[i][j] == 1)
                {
                    int hasMoreThanOne = dfs(i , j , row , col , grid);
                    if(hasMoreThanOne==1) continue;
                    system +=hasMoreThanOne;
                }                
            }
        }

        return system;
    }

    int dfs(int r , int c , int row , int col , int[][] grid)
    {
        grid[r][c] = 0;
        int res = 1;
        
        for (int x = 0; x < row; x++) {
            if (grid[x][c] == 1) {
                res += dfs(x,c,row,col,grid);
            }
        }
        for (int x = 0; x < col; x++) {
            if (grid[r][x] == 1) {
                res += dfs(r,x,row,col,grid);
            }
        }

        return res;
    }
}