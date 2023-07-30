package com.example.gspractice;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for(char[] chars : grid) Arrays.fill(chars , '.');
        List<List<String>> result = new ArrayList<>();
        solve(grid , result , n , n , 0);
        return result;
    }

    void solve(char[][] grid , List<List<String>> result , int row , int col , int curr)
    {
        if(curr == col)
        {
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i<row;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<col;j++)
                {
                    sb.append(grid[i][j]);
                }
                list.add(sb.toString());
            }
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<row;i++)
        {
            if(grid[i][curr] == '.')
            {
                if(isValid(i , curr , row , col , grid))
                {
                    grid[i][curr] = 'Q';
                    solve(grid , result , row , col , curr+1);
                    grid[i][curr] = '.';
                }
            }
           
        }
    }

    boolean isValid(int r , int c , int row , int col , char[][] grid)
    {
        int lR = r;
        int lC = c;
        
        while(lR>=0 && lC>=0)
        {
            if(grid[lR][lC] == 'Q') return false; 
            lR--;
            lC--;
        }
        lR = r;
        lC = c;

        while(lC>=0)
        {
            if(grid[lR][lC] == 'Q') return false;
            lC--;
        }
        lR = r;
        lC = c;

        while(lR<row && lC>=0)
        {
            if(grid[lR][lC] == 'Q') return false;
            lC--;
            lR++;
        }

        return true;
    }
}