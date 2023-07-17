package com.example.microsoftpractice;

public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        int INF = -(r*c);
        for(int i=0;i<r;i++)
        {
            int[] dummy = new int[c];

            for(int j=i;j<r;j++)
            {
                for(int k = 0 ; k<c; k++) dummy[k] += matrix[j][k]=='0'?INF:1;
                int sum = kadaneAlgo(dummy);

                max = Math.max(max , sum);
            }
        }

        return max;
    }

    int kadaneAlgo(int[] arr)
    {
        int sumSoFar = arr[0];
        int sumMax = arr[0];

        for(int i=1; i<arr.length;i++)
        {
            sumSoFar = Math.max(sumSoFar+arr[i] , arr[i]);
            sumMax = Math.max(sumMax , sumSoFar);
        }

        return sumMax;

    }
}