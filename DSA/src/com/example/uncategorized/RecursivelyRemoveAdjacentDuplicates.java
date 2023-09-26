package com.example.uncategorized;

// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1

public class RecursivelyRemoveAdjacentDuplicates{
	String rremove(String s) {
		// code here
		String res = "";

		while(! res.equals(s))
		{
			res = s;
			s = function(s);
		}

		return res;
	}

	String function(String s)
	{
		if(s.length() == 0) return s;

		StringBuilder res = new StringBuilder();

		for(int i=0;i<s.length();i++)
		{
			boolean hasDups = false;
			while(i+1<s.length() && s.charAt(i) == s.charAt(i+1))
			{
				hasDups = true;
				i++;
			}

			if(! hasDups) res.append(s.charAt(i));
		}

		return res.toString();
	}
}