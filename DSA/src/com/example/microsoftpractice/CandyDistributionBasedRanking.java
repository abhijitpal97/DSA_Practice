package com.example.microsoftpractice;

import java.util.Arrays;

public class CandyDistributionBasedRanking {
	public int candy(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		Arrays.fill(ans , 1);
		for(int i=1;i<n;i++)
		{
			if(A[i]>A[i-1])
			{
				while(ans[i]<=ans[i-1]) ans[i]++; 
			}
		}

		for(int i=n-2;i>=0;i--)
		{
			if(A[i]>A[i+1])
			{
				while(ans[i]<=ans[i+1]) ans[i]++; 
			}
		}

		int sum = 0;
		for(int i : ans) sum += i;

		return sum;
	}
}
