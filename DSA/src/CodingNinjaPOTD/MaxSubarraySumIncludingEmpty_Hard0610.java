package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MaxSubarraySumIncludingEmpty_Hard0610 {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long maxSoFar = arr[0];
		long max = arr[0];

		for(int i=1;i<n;i++)
		{
			maxSoFar = Math.max(maxSoFar+arr[i], arr[i]);
			max = Math.max(max , maxSoFar);
		}

		if(max<0) return 0;
		return max;
	}

}
