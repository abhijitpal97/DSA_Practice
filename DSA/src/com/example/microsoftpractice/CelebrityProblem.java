package com.example.microsoftpractice;

// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

public class CelebrityProblem
{ 
	//Function to find if there is a celebrity in the party or not.
	int celebrity(int M[][], int n)
	{
		// code here 
		int[] inDegree = new int[n];
		int[] outDegree = new int[n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(M[i][j]==1)
				{
					inDegree[j]++;
					outDegree[i]++;
				}
			}
		}

		for(int i=0 ; i<n;i++)
		{
			if(inDegree[i] == n-1 && outDegree[i] == 0) return i;
		}

		return -1;
	}
}