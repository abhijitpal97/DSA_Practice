package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TrieNode;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {
	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			if(curr.childrens[ch -'a'] == null)
			{
				TrieNode node = new TrieNode();
				curr.childrens[ch - 'a'] = node;
			}
			curr = curr.childrens[ch - 'a'];
		}
		curr.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			if(curr.childrens[ch -'a'] == null) return false;
			curr = curr.childrens[ch - 'a'];
		}

		return curr.isEndOfWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode curr = root;

		for(char ch : prefix.toCharArray())
		{
			if(curr.childrens[ch -'a'] == null) return false;
			curr = curr.childrens[ch - 'a'];
		}

		return true;
	}
}