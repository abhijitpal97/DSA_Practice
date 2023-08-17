package com.example.gspractice;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i] , '.');
        List<List<String>> result = new ArrayList<>();
        solve(board , n , 0,result);
        return result;
    }

    void solve(char[][] board , int n , int row , List<List<String>> result)
    {
        if(row == n)
        {
            constructResult(board , result,n);
            return;
        }
        for(int i = 0 ; i<n;i++)
        {
            if(isValid(board , row , i , n))
            {
                board[row][i] = 'Q';
                solve(board , n , row+1,result);
                board[row][i] = '.';
            }
            
        }
    }

    void constructResult(char[][] board , List<List<String>> result,int n)
    {
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++)
            {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        result.add(list);
    }

    boolean isValid(char[][] grid , int r , int c , int n)
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

        while(lR>=0 && lC<n)
        {
            if(grid[lR][lC] == 'Q') return false;
            lC++;
            lR--;
        }

        lR = r;
        lC = c;

        while(lR>=0)
        {
            if(grid[lR][lC] == 'Q') return false;
            lR--;
        }

        return true;
    }
}