package com.example.gspractice;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class RemoveDuplicateFromStringKOccuranceRecursive {
	public String removeDuplicates(String s, int k) {
		String res = "";
		while(! s.equals(res))
		{
			res = s;
			s = function(res , k);
			System.out.println(s);
		}

		return s;
	}

	String function(String str , int k)
	{
		if(str.length() <= 1) return str;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++)
		{
			char ch = str.charAt(i); //a
			boolean hasDups = false;
			int count = 1;
			while(i+1<str.length() && str.charAt(i+1) == ch)
			{
				i++;
				hasDups = true;
				count++;
				if(i+1 == str.length()) break;
			}

			if(! hasDups) sb.append(ch); //ddbd
			else if(hasDups && count < k) 
			{
				for(int j = 0 ;j<count;j++) sb.append(ch);
			}

		}

		return sb.toString();
	}
}