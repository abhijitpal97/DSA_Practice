package com.example.amazonpractice;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/word-ladder-ii/1

public class WordLadder2
{
	public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
	{
		// Code here
		Queue<ArrayList<String>> queue = new LinkedList<>();
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> used = new ArrayList<>();
		int level = 0 ;
		List<String> wordLists = new ArrayList<>();
		for(String str:wordList) wordLists.add(str);

		queue.offer(new ArrayList<>(Arrays.asList(startWord)));
		used.add(startWord);

		while(! queue.isEmpty())
		{
			ArrayList<String> curr = queue.poll();

			if(curr.size()>level)
			{
				level++;
				for(String str : used) wordLists.remove(str);
			}

			String word = curr.get(curr.size()-1);

			if(word.equals(targetWord))
			{
				ans.add(curr);
			}

			for(int i = 0; i<word.length();i++)
			{
				for(char ch ='a' ; ch<='z';ch++)
				{
					char[] chars = word.toCharArray();
					chars[i] = ch;
					String newString = new String(chars);
					if(wordLists.contains(newString))
					{
						used.add(newString);
						curr.add(newString);
						queue.offer(new ArrayList<>(curr));
						curr.remove(curr.size()-1);
					}
				}
			}
		}

		return ans;
	}
}