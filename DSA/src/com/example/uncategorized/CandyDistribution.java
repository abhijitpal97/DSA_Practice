package com.example.uncategorized;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/candy-distribution_5038447

public class CandyDistribution {
	static long candyDistribution(int n, ArrayList<Integer> a) {
		// Write your code here.
		Collections.sort(a);
		int candy = 0;
		int last = 0;

		for(int i=0;i<n;i++)
		{
			if(a.get(i) > last) last = a.get(i);
			else last++;

			candy +=last;
		}

		return candy;
	}
}