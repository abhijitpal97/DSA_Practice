package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class largestSumRectangleMatrix_Moderate3007
{
public static int largestSquareSubmatrix(int[][] mat, int n, int m, int k)
    {
        // Write your code here.
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i<n;i++)
        {
            int[] dummy = new int[m];

            for(int j =i;j<n;j++)
            {
                for(int k1 = 0 ; k1<m;k1++) dummy[k1] += mat[j][k1];
                int sum = kadaneAlgorithm(dummy ,  k);
                max = Math.max(max , sum);
            }
        }

        return max;
    }

    static int kadaneAlgorithm(int[] arr , int k)
    {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int sum = 0;
            for(int j = i ; j<arr.length;j++)
            {
                sum += arr[j];
                if(sum<=k) maxSum = Math.max(maxSum , sum);
            }
        }
        return maxSum;
    }
}
