package com.example.apple;

import java.util.Arrays;

// https://leetcode.com/problems/zigzag-conversion/

public class ZigZagConversion {
	public static void main(String[] args)
	{
		String res = convert("AB", 3);
		System.out.println(res);
	}
	public static String convert(String s, int numRows) {
		if(numRows == 1) return s;
		String[] strs = new String[numRows];
		boolean dir = true;
		Arrays.fill(strs , "");
		strs[0] += s.charAt(0);
		for(int i = 1 ; i<s.length() ; i++)
		{
			if(i == s.length()) break;
			if(dir)
			{
				for(int j=1;j<numRows; j++)
				{
					strs[j] += s.charAt(i);
					i++;
					if(i == s.length()) break;
				}
				dir = !dir;
			}

			if(i == s.length()) break;
			if(!dir)
			{
				for(int j=numRows-2;j>=0; j--)
				{
					strs[j] += s.charAt(i);
					i++;
					if(i == s.length()) break;
				}
				dir = !dir;
			}
			i--;
		}

		StringBuilder sb = new StringBuilder();
		for(String str : strs) sb.append(str);

		return sb.toString();
	}
}