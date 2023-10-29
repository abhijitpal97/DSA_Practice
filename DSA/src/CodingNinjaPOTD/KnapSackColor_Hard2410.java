package CodingNinjaPOTD;

import java.util.*;

// https://www.codingninjas.com/studio/problems/hard_6581696

public class KnapSackColor_Hard2410 {
	static int min = Integer.MAX_VALUE;
	public static int colorfulKnapsack(int w[], int c[], int m, int x) {
		//    Your code goes here..
		Set<Integer> set = new HashSet<>();
		min = Integer.MAX_VALUE;

		function(0 , x , set , c , 0 , w , m);

		return min==Integer.MAX_VALUE?-1:min;
	}

	static void function(int curr, int target , Set<Integer> set , int[] color ,
			int index , int[] w , int m)
	{
		if(curr>target) return;
		if(set.size() == m)
		{
			min = Math.min(min , target -curr);
			return;
		}
		if(index >= w.length) return;

		if(set.contains(color[index]))
		{
			function(curr , target , set , color , index+1 , w, m);
		}
		else
		{
			set.add(color[index]);
			function(curr+w[index] , target , set , color , index+1 , w , m);
			set.remove(color[index]);
			function(curr , target , set , color , index+1 , w, m);
		}

	}

	// Memorization

	public static int colorfulKnapsackMemo(int w[], int c[], int m, int x) {
		//    Your code goes here.

		ArrayList<ArrayList<Integer>> colorWeights = new ArrayList<>();

		for (int i = 0; i <= m; i++) {
			colorWeights.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < c.length; i++) {
			colorWeights.get(c[i]).add(w[i]);
		}

		Integer[][] dp = new Integer[m+1][x+1];

		int ans = function(colorWeights , 1 , 0 , x , dp);

		if(ans == Integer.MIN_VALUE) return -1;
		return x-ans;
	}

	public static int function(ArrayList<ArrayList<Integer>> colorWeights, int currColor,
			int currWeight, int x, Integer[][] dp) {

		if (currColor >= colorWeights.size()) {
			return 0;
		}

		if (dp[currColor][currWeight] != null) {
			return dp[currColor][currWeight];
		}

		int ans = Integer.MIN_VALUE;

		for (int weight: colorWeights.get(currColor)) {

			if (weight + currWeight <= x) {

				int furtherAns = function(colorWeights,currColor + 1,
						currWeight + weight, x, dp);

				if (furtherAns != Integer.MIN_VALUE) {
					ans = Math.max(ans,furtherAns + weight);
				}
			}
		}

		return dp[currColor][currWeight] = ans;

	}

}