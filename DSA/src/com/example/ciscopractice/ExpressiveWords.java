package com.example.ciscopractice;

// https://leetcode.com/problems/expressive-words/description/

public class ExpressiveWords {
	public int expressiveWords(String s, String[] words) {
		int count = 0;
		for (String word : words) {
			if (isValid(s, word)) {
				count++;
			}
		}
		return count;
	}

	boolean isValid(String s , String t)
	{
		int i =0;
		int j =0;

		while(i<s.length() && j<t.length())
		{
			if(s.charAt(i) != t.charAt(j)) return false;
			else
			{
				int sCount=1;
				while(i<s.length()-1 && s.charAt(i) == s.charAt(i+1))
				{
					i++;
					sCount++;
				}

				int tCount=1;
				while(j<t.length()-1 && t.charAt(j) == t.charAt(j+1))
				{
					j++;
					tCount++;
				}

				if(tCount>sCount) return false;

				if(sCount>tCount && sCount<3) return false;

				i++;
				j++;
			}
		}

		if(j<t.length()) return false;
		if(i<s.length()) return false;

		return true;
	}
}