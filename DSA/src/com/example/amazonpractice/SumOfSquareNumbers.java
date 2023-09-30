package com.example.amazonpractice;

// https://leetcode.com/problems/sum-of-square-numbers/description/

public class SumOfSquareNumbers {
	public boolean judgeSquareSum(int c) {
		long end = (long)Math.sqrt(c);
		long start = 0 ;
		while(start<=end)
		{
			long sum = (start*start) + (end*end);
			if(sum == c)  return true;
			else if(sum>c) end--;
			else if(sum<c) start++;
		}
		return false;
	}
}