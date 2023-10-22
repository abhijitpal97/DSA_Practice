package com.example.gspractice;

// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/

public class MinimumLengthPrefixSuffixDeletion {
	public static void main(String[] args)
	{
		int res = minimumLength("aba");
		System.out.println(res);
	}

	public static int minimumLength(String s) {
		int start = 0;
		int end=s.length();
		if(s.length()<2) return s.length();
		while(start<end)
		{
			String res = s;
			start=0;
			end=s.length()-1;
			if(res.charAt(end)== res.charAt(start))
			{
				char ch = res.charAt(start);
				while(res.charAt(start)== ch && start<end) start++;
				while(res.charAt(end)== ch && start<end) end--;

				if(start == end && res.charAt(start)==ch) return 0;
				if(start == end && res.charAt(start) !=ch) return 1;
				res=res.substring(start,end+1);
				if(res.equals(s)) return res.length();
				s=res;
			}
			else return res.length();


		}

		return s.length();
	}
}