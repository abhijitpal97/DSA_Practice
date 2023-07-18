package com.example.amazonpractice;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] answer = new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int l = Math.max(0 , j-k);
                int r = Math.min(col-1 , j+k);
                int u= Math.max(0 , i-k);
                int d = Math.min(row-1 , i+k);

                answer[i][j] = sum(mat , l , r , u , d);
            }
        }

        return answer;
    }

    int sum(int[][] mat , int l , int r , int u , int d)
    {
        int s = 0;
        for(int i = u ; i<=d ; i++)
        {
            for(int j = l ; j<=r;j++)
            {
                s +=mat[i][j];
            }
        }

        return s;
    }
}