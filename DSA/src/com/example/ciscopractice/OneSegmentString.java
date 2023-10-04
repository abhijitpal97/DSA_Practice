package com.example.ciscopractice;

// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/

public class OneSegmentString {
	public boolean checkOnesSegment(String s) {
		if(s.length() == 1 && s.charAt(0) == '1') return true;

		int count =0;
		char ch = s.charAt(0);
		for(int i=1;i<s.length();i++)
		{
			if(ch=='1' && s.charAt(i)=='1') continue;
			else
			{
				if(ch == '1') count++;
				ch = s.charAt(i);
			}
			if(count>1) return false; 
		}
		if(ch == '1') count++;
		if(count>1) return false;

		return true;
	}
}