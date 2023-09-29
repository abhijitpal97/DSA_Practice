package com.example.amazonpractice;


// https://leetcode.com/problems/repeated-string-match/description/

public class RepeatedStringMatch {
	public int repeatedStringMatch(String a, String b) {
		String str="";
		int count = 0;

		while(str.length()<(b.length()+2*a.length()))
		{
			str += a;
			count++;
			if(str.contains(b)) return count;
		}

		return -1;
	}

	// Simplified
	public int repeatedStringMatchSimple(String a, String b) {
		String str=a;
		int count =1;
		int repeat = b.length() / a.length();
		for(int i=0;i<repeat+2 ; i++)
		{
			if(a.contains(b)) return count;

			a+=str;
			count++;
		}

		return -1;
	}
}