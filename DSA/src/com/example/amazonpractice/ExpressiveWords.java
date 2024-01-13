package com.example.amazonpractice;

// https://leetcode.com/problems/expressive-words/

public class ExpressiveWords {
	public static void main(String[] args)
	{
		int res = expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"});
		System.out.println(res);
	}
	public static int expressiveWords(String s, String[] words) {
		int count = 0;

		for(String str : words)
		{
			if(checkIfExpressive(s , str)) count++;
		}

		return count;
	}

	static boolean checkIfExpressive(String str , String word)
	{
		int sLen = str.length();
		int sStart = 0;
		int wLen = word.length();
		int wStart = 0;

		while(sStart<sLen && wStart<wLen)
		{
			if(str.charAt(sStart) != word.charAt(wStart)) return false;
			else
			{
				int sCount = 1 ;
				while(sStart<sLen-1 && str.charAt(sStart)==str.charAt(sStart+1))
				{
					sCount++;
					sStart++;
				}

				int tCount = 1 ;
				while(wStart<wLen-1 && word.charAt(wStart)==word.charAt(wStart+1))
				{
					tCount++;
					wStart++;
				}

				if(tCount>sCount) return false;
				if(sCount>tCount && sCount<3) return false;

				sStart++;
				wStart++;
			}
		}   
		if(sStart != sLen || wStart != wLen) return false;
		return true;     
	}
}