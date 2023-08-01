package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MaxSumSubMatrix_Moderate0108 {
    public static int maxSumSubmatrix(int mat[][], int n, int m) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int[] dummy = new int[m];
            for(int j = i ; j<n ; j++)
            {
                for(int k = 0 ; k<m;k++) dummy[k] +=mat[j][k];
                int sum = kadaneAlgo(dummy);
                max = Math.max(max , sum);
            }
        }
        return max;
    }

    static int kadaneAlgo(int[] arr)
    {
        int maxSoFar = arr[0];
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            maxSoFar = Math.max(maxSoFar+arr[i] , arr[i]);
            max = Math.max(max , maxSoFar);
        }
        return max;
    }
}
