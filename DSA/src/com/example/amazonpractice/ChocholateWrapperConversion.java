package com.example.amazonpractice;

// https://www.hackerrank.com/challenges/chocolate-feast/problem

public class ChocholateWrapperConversion {
	public static int chocolateFeast(int n, int c, int m) {
		// Write your code here
		int initial = n/c;  //3
		if(initial<m) return initial;
		int wrapper = initial; 
		while(wrapper>=m)
		{
			int converted =wrapper/m;  //0
			wrapper =  converted +wrapper%m; //1

			initial+=converted;  //4

		}

		return initial;

	}


}