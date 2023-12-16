package com.example.olapractice;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/minimum-sum-in-matrix_893294

class MinimumSumTuple
{
	int index;
	int sum;
	int r;

	MinimumSumTuple(int index , int sum , int r)
	{
		this.index = index;
		this.sum = sum;
		this.r = r;
	}
}

public class MinimumSumMatrix {

	public static int minSum(ArrayList<ArrayList<Integer>> arr) {

		// Write your code here
		int row = arr.size();
		int col = arr.get(0).size();

		Queue<MinimumSumTuple> queue = new PriorityQueue<>((a,b) -> a.sum - b.sum);
		for(int i =0; i<col ; i++) queue.offer(new MinimumSumTuple(i , arr.get(0).get(i) , 0));

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i = 0 ; i<size ; i++)
			{
				MinimumSumTuple curr = queue.poll();
				int r = curr.r;
				int index = curr.index;
				int sum = curr.sum;

				if(r == row-1) return sum;

				for(int j=0;j<col ; j++)
				{
					if(j != index) queue.offer(new MinimumSumTuple(j , sum+arr.get(r+1).get(j) , r+1));
				}
			}
		}

		return -1;
	}

	// Memorization

	public static int minSumMemo(ArrayList<ArrayList<Integer>> arr) {

		// Write your code here
		int n = arr.size();
		int ans = Integer.MAX_VALUE;

		Integer[][] dp = new Integer[n+1][4];

		for(int i=0; i<3;i++)
		{
			ans = Math.min(ans , solve(0 , i , n , arr , dp));
		}

		return ans;
	}

	static int solve(int r , int c , int n , ArrayList<ArrayList<Integer>> arr ,
			Integer[][] dp)
	{
		if(r==n-1) return arr.get(r).get(c);
		if(dp[r][c] != null) return dp[r][c];

		int curr = Integer.MAX_VALUE;

		for(int k=0;k<3;k++)
		{
			if(k != c) curr = Math.min(curr , arr.get(r).get(c)+solve(r+1 , k , n , arr , dp));
		}

		return dp[r][c] = curr;
	}
}
