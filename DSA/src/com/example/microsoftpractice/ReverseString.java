package com.example.microsoftpractice;

// https://leetcode.com/problems/reverse-words-in-a-string/description/

public class ReverseString {
	public String reverseWords(String s) {
		s= s.trim();
		String[] strArray = s.split("\\s");
		StringBuilder sb = new StringBuilder();
		for(int i=strArray.length-1; i>=0 ; i--) 
		{
			if(strArray[i].trim() != "") sb.append(strArray[i].trim()).append(" ");
		}

		return sb.substring(0 , sb.length()-1).toString();
	}
}