package com.example.amazonpractice;

import com.example.datastructure.skeleton.TrieNode;

public class WordDictionaryUsingTrie {
	TrieNode root;
	public WordDictionaryUsingTrie() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode currNode = root;
		for(int i= 0 ; i<word.length();i++)
		{
			char cur = word.charAt(i);
			if(currNode.childrens[cur - 'a'] == null)
			{
				TrieNode newNode = new TrieNode();
				currNode.childrens[cur - 'a'] = newNode;
			}
			currNode = currNode.childrens[cur - 'a'];
		}
		currNode.isEndOfWord = true;
	}

	public boolean search(String word) {
		return search(word , root , 0);
	}

	public boolean search(String word , TrieNode node , int index) {
		if(word.length()==index) return node.isEndOfWord;
		if(node == null) return false;

		if(word.charAt(index) != '.' && node.childrens[word.charAt(index) - 'a'] == null) return false;

		if(word.charAt(index) == '.')
		{
			boolean flag = false;
			for(int i=0;i<26;i++)
			{
				if(node.childrens[i] != null)
				{
					TrieNode curr = node.childrens[i];
					flag = flag || search(word , curr , index+1);
					if(flag) return flag;
				}
			}

			return flag;
		}
		else
		{
			node = node.childrens[word.charAt(index) - 'a'];
			if(node != null) return search(word , node , index+1);
			else return false;
		}
	}
}