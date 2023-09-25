package com.example.amazonpractice;

// https://leetcode.com/problems/count-binary-substrings/description/

public class EqualZeroOnesContinuously {
	public int countBinarySubstrings(String s) {
		int c0 = 0;
		int c1= 0;
		int sum = 0;

		for(int i=0;i<s.length();i++)
		{
			if(i>0 && s.charAt(i) != s.charAt(i-1))
			{
				sum += Math.min(c0, c1);
				if(s.charAt(i) == '0') c0=0;
				else c1=0;
			}

			if(s.charAt(i)=='0') c0++;
			else c1++;
		}

		sum += Math.min(c0,c1);
		return sum;
	}
}