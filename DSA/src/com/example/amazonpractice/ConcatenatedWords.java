package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TrieNode;
// https://leetcode.com/problems/concatenated-words/

public class ConcatenatedWords {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> list= new ArrayList<String>();
		TrieNode trie = new TrieNode();
		for(String str : words)
		{
			insert(str,trie);
		}

		for(String str : words)
		{
			if(solve(str , trie , 0 , new Boolean[str.length()] , 0)) list.add(str);
		}
		return list;
	}

	boolean solve(String str , TrieNode trie , int index , Boolean[] dp , int count)
	{

		if(index == str.length())
		{
			return count>1;
		}

		if(dp[index] != null) return dp[index];

		TrieNode dict = trie;

		for(int i = index ; i<str.length();i++)
		{
			dict = dict.childrens[str.charAt(i)-'a'];
			if(dict == null) return dp[index] = false;
			if(dict.isEndOfWord)
			{
				if(solve(str , trie , i+1 , dp , count+1)) return dp[index] = true;
			}
		}

		return dp[index] = false;

	}

	void insert(String str , TrieNode trie)
	{
		for(char ch : str.toCharArray())
		{
			if(trie.childrens[ch -'a'] == null)
			{
				TrieNode newTrie = new TrieNode();
				trie.childrens[ch-'a'] = newTrie;
			}
			trie = trie.childrens[ch-'a'];
		}
		trie.isEndOfWord = true;
	}
}