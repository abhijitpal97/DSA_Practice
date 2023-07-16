package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MaxSumQueriesInterval_Hard1607 {
    public static int[] solve(int n, int[] arr, int q, int[][] queries){
    	// Write your code here
        int[] res = new int[q];
        for(int i=0;i<q;i++)
        {
            res[i] = maxSumArray(arr , queries[i][0], queries[i][1]);
        }

        return res;
    }  

    static int maxSumArray(int[] arr, int start , int end)
    {
        int maxSumSoFar=arr[start];
        int maxSum = arr[start];

        for(int i=start+1;i<=end;i++)
        {
            maxSumSoFar = Math.max(maxSumSoFar+arr[i] , arr[i]);
            maxSum = Math.max(maxSum , maxSumSoFar);
        }

        return maxSum;
    }     
}