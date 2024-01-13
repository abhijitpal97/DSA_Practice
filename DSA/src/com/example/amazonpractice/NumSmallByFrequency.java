package com.example.amazonpractice;
// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

public class NumSmallByFrequency {
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int n = queries.length;
		int m = words.length;

		int[] wCount = new int[m];
		int index = 0;
		for(String str : words)
		{
			int[] chars = new int[26];

			for(char ch : str.toCharArray())
			{
				chars[ch - 'a']++;
			}

			for(int i =0 ; i<26;i++)
			{
				if(chars[i] != 0)
				{
					wCount[index] = chars[i];
					break;
				} 
			}

			index++;
		}

		int[] res = new int[n];
		index = 0;

		for(String q : queries)
		{
			int[] chars = new int[26];
			for(char ch : q.toCharArray())
			{
				chars[ch - 'a']++;
			}

			int count = 0;

			for(int i =0 ; i<26;i++)
			{
				if(chars[i] != 0)
				{
					count = chars[i];
					break;
				} 
			}

			int c = 0;
			for(int i =0 ; i<m ; i++)
			{
				if(count<wCount[i]) c++;
			}

			res[index] = c;
			index++;
		}

		return res;
	}
}