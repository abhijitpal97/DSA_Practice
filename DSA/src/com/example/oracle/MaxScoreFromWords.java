package com.example.oracle;

// https://leetcode.com/problems/maximum-score-words-formed-by-letters/

public class MaxScoreFromWords {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0) return 0;

		int[] count = new int[score.length];
		for(char ch : letters) count[ch - 'a']++;
		int res = backtrack(words,score,0,count);
		return res;
	}

	int backtrack(String[] words, int[] score, int index, int[] count)
	{
		int max = 0;

		for(int i=index; i<words.length; i++)
		{
			int res = 0;
			boolean flag = true;
			for(char ch : words[i].toCharArray())
			{
				count[ch-'a']--;
				res += score[ch-'a'];
				if(count[ch - 'a']<0) flag = false;
			}

			if(flag)
			{
				res += backtrack(words,score,i+1,count);
				max = Math.max(max , res);
			}

			for(char ch : words[i].toCharArray())
			{
				count[ch-'a']++;
			}
		}

		return max;
	}
}