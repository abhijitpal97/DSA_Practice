package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MaxContinuousSumForKRepetation {
	static int MOD = 1000000007;
	public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
		// Write your code here.
		int maxSoFar = arr.get(0);
		int max = arr.get(0);
		for(int i=1;i<n*k;i++)
		{
			int curr = i%n;
			maxSoFar = Math.max((maxSoFar+arr.get(curr))%MOD , arr.get(curr)%MOD);
			max = Math.max(max , maxSoFar);
		}
		return max;
	}
}