package com.example.amazonpractice;

// https://leetcode.com/discuss/interview-question/1856295/Amazon-Question
public class GetSumQueries
{
	public static void main(String[] args)
	{
		int sum = getSumQueries(new int[] {1,2,1,3,1,2,1}, 
				new int[][] {{1,3,3},{0,4,1},{2,5,2},{5,6,1}});

		System.out.println(sum);
	}
	public static int getSumQueries(int[] arr , int[][] queries)
	{
		int sum = 0;
		for(int i=0;i<queries.length; i++)
		{
			int start = queries[i][0];
			int end = queries[i][1];
			int num = queries[i][2];

			int count = 0;
			for(int j=start;j<=end ; j++)
			{
				if(arr[j] ==  num) count++;
			}

			sum+=count;
		}

		return sum;
	}
}