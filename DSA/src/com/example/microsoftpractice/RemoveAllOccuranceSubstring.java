package com.example.microsoftpractice;

// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

public class RemoveAllOccuranceSubstring {
	public String removeOccurrences(String s, String part) {
		String res = "";
		while(s != res)
		{
			res = s;
			s = helper(s,part); 
		}   
		return res;
	}

	String helper(String s , String part)
	{
		if(s.length() == 0) return s;
		int index = s.indexOf(part);
		if(index == -1) return s;

		s = s.substring(0,index)+s.substring(index+part.length());

		return s;

	}
}