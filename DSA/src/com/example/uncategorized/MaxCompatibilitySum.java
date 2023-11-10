package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/maximum-compatibility-score-sum/

public class MaxCompatibilitySum {
	static int max = 0;

	public static void main(String[] args)
	{
		int res = maxCompatibilitySum(
				new int[][]{{1,1,0},{1,0,1},{0,0,1}}, 
				new int[][]{{1,0,0},{0,0,1},{1,1,0}});
		System.out.println(res);
	}
	public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
		int r = students.length;
		boolean[] isVisited =  new boolean[r];
		helper(isVisited,students,mentors,0,0,r);
		return max;
	}

	static void helper(boolean[] isVisited,int[][] students, int[][] mentors,int pos , int score,int n)
	{
		if(pos>=n)
		{
			max = Math.max(max , score);
			return;
		}

		for(int i=0;i<n;i++)
		{
			if(! isVisited[i])
			{
				isVisited[i] = true;
				helper(isVisited,students,mentors,pos+1,score+score(students[pos],mentors[i]),n);
				isVisited[i] = false;
			}
		}
	}

	static int score(int[] student  , int[] mentor)
	{
		int count =0 ;
		for(int i=0;i<student.length;i++)
		{
			if(student[i] == mentor[i]) count++;
		}

		return count;
	}
}