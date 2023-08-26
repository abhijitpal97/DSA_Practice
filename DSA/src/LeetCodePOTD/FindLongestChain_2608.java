package LeetCodePOTD;

import java.util.*;

public class FindLongestChain_2608 {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs , (a , b) -> a[1] - b[1]);
		int n = pairs.length;
		Integer[] dp = new Integer[n+1];

		return function(pairs , Integer.MIN_VALUE , 0 , dp);
	}

	int function(int[][] pairs , int last , int index , Integer[] dp)
	{
		if(index >= pairs.length) return 0;
		if(dp[index] != null) return dp[index];

		int pick = Integer.MIN_VALUE;
		if(pairs[index][0] > last) 
		{
			pick = 1+function(pairs , pairs[index][1] , index+1 , dp);
		}
		int notPick = function(pairs , last , index+1 , dp);

		return dp[index] = Math.max(pick , notPick);
	}
}


