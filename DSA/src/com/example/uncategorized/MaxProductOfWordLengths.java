package com.example.uncategorized;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-of-word-lengths/description/

public class MaxProductOfWordLengths {
	public static void main(String[] args)
	{
		int res = maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"});
		System.out.println(res);
	}
	public static int maxProduct(String[] words) {
		Arrays.sort(words , (a,b) -> Integer.compare(b.length(), a.length()));
		int max = 0;

		for(int i=0 ; i<words.length ; i++)
		{
			char[] chars = new char[26];
			for(char ch : words[i].toCharArray()) chars[ch - 'a']++;

			for(int j = i+1 ; j<words.length ; j++)
			{
				boolean flag = false;

				for(char ch : words[j].toCharArray())
				{
					if(chars[ch - 'a'] > 0)
					{
						flag = true;
						break;
					}
				}

				if(! flag)
				{
					max = Math.max(max , words[i].length() * words[j].length());
					break;
				}

			}
		}

		return max;
	}
}