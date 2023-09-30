package com.example.amazonpractice;

// https://leetcode.com/problems/string-to-integer-atoi/description/

public class StringToAtoi {
	public int myAtoi(String s) {
		s = s.trim();
		if(s.length() == 0) return 0;
		boolean isNegetive =  (s.charAt(0)=='-')?true:false;
		if(isNegetive || s.charAt(0)=='+') s=s.substring(1);
		if(s.length() == 0) return 0;
		if(s.charAt(0) == ' ') return 0;
		double result = 0;
		boolean nonDigitStarted = false;
		for(int i=0;i<s.length();i++)
		{
			if(Character.isDigit(s.charAt(i)))
			{
				int curr = Character.getNumericValue(s.charAt(i));
				result = result*10 + curr;
				//System.out.println(result);
			}
			else nonDigitStarted = true;
			if(nonDigitStarted) break;
		}

		result = isNegetive==true? -1*result:result;
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return (int)result;
	}
}