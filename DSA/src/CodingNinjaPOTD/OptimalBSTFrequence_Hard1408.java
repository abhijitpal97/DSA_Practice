package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class OptimalBSTFrequence_Hard1408 {
	public static int optimalCost(ArrayList<Integer> keys, ArrayList<Integer> freq, int n) {
		// Write your code here.
		Integer[][][] dp = new Integer[n][n][n+1];
		return function(keys , freq , n , 0 , n-1 , 1 , dp);
	}

	static int function(ArrayList<Integer> keys, ArrayList<Integer> freq, int n , 
	int start , int end  , int level ,  Integer[][][] dp)
	{
		if(start>end) return 0;
		if(start==end) return freq.get(start)*level;
		if(dp[start][end][level] != null) return dp[start][end][level];

		int result = Integer.MAX_VALUE;
		for(int i = start ; i<=end ; i++)
		{
			int left = function(keys , freq , n , start , i-1 , level+1 , dp);
			int right = function(keys , freq , n , i+1 , end , level+1 , dp);

			int rootF = freq.get(i)*level;
			int total = rootF+left+right;

			result = Math.min(result , total);
		}

		return dp[start][end][level] = result;
	}
}