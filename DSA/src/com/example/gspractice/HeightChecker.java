package com.example.gspractice;

import java.util.*;


public class HeightChecker {

	public static void main(String[] args)
	{
		int res = heightChecker(new int[] {2,1,2,1,1,2,2,1});
		System.out.println(res);
	}

	public static int heightChecker(int[] heights) {

		int[] dups = new int[heights.length];
		for(int i=0;i<heights.length;i++) dups[i] = heights[i];
		Arrays.sort(dups);
		int count=0;
		for(int i=0;i<heights.length;i++) 
		{
			if(heights[i] != dups[i]) count++;
		}

		return count;

	}
}