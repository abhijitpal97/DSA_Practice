package com.example.microsoftpractice;

public class SetZeroesRowandColums {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j] == 0) setValue(i , j , matrix , row , col);
            }
        }

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j] == (int)1e8) matrix[i][j] = 0;
            }
        }
    }

    void setValue(int r , int c , int[][] matrix , int row , int col)
    {
        for(int i=0;i<row;i++)
        {
            if(matrix[i][c] != 0) matrix[i][c] = (int)1e8;
        }
        for(int i=0;i<col;i++)
        {
            if( matrix[r][i] != 0) matrix[r][i] = (int)1e8;
        }
    }
}