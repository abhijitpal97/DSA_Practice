package com.example.gspractice;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1

public class PrintLargestPossibleNumberString {
	String printLargest(String[] arr) {
		// code here

		Arrays.sort(arr , new Comparator<String>()
		{
			public int compare(String x , String y)
			{
				String xy = x+y;
				String yx = y+x;

				return xy.compareTo(yx)>0?-1:1;
			}
		});


		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++)
		{
			sb.append(arr[i]);
		}

		return sb.toString();
	}
}