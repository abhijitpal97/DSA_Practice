package com.example.amazonpractice;

// https://leetcode.com/problems/stone-game/

public class PredictWinner_StoneGame {
	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		Integer[][][] dp = new Integer[n][n][2];
		int total = 0;
		for(int i : piles) total +=i;
		int p1 = function(piles , 0 , n-1,0,dp);
		int p2 = total-p1;
		return p1>p2;

	}

	int function(int[] piles , int startIndex , int endIndex , int player , Integer[][][] dp)
	{
		if(startIndex>endIndex) return 0;
		if(startIndex==endIndex) return piles[startIndex];

		if(dp[startIndex][endIndex][player] != null) return dp[startIndex][endIndex][player];

		int pileC = 0;
		if(player==0)
		{
			pileC = Math.max(piles[startIndex] + function(piles , startIndex+1 , endIndex , 1 , dp) , 
					piles[endIndex] + function(piles , startIndex , endIndex-1 , 1 , dp));
		}
		else
		{
			pileC = Math.min(function(piles , startIndex+1 , endIndex , 0 , dp) , 
					function(piles , startIndex , endIndex-1 , 0 , dp));
		}

		return dp[startIndex][endIndex][player] = pileC;
	}

	// Alternate Memorization - O(n^3)

	public boolean stoneGameMemo(int[] piles) {
		int n = piles.length;
		Boolean[][][] dp = new Boolean[n][n][2];

		return functionMemo(piles,n,dp , 0 , 0 , 0 , n-1 , 0);
	}

	boolean functionMemo(int[] piles,int n , Boolean[][][] dp , int alice , int bob , int start , int end , int aliceT)
	{
		if(start>end) return alice>bob;

		if(dp[start][end][aliceT] != null) return dp[start][end][aliceT];

		boolean aF = false;
		boolean aL = false;
		boolean bF = false;
		boolean bL = false;

		if(aliceT==0)
		{
			aF = functionMemo(piles,n,dp,piles[start]+alice,bob,start+1,end,1);
			aL = functionMemo(piles,n,dp,piles[end]+alice,bob,start,end-1,1);
		}

		else if(aliceT==1)
		{
			bF = functionMemo(piles,n,dp,alice,piles[start]+bob,start+1,end,0);
			bL = functionMemo(piles,n,dp,alice,piles[end]+bob,start,end-1,0);
		}

		return dp[start][end][aliceT] = aF||bF||aL||bL;

	}
}