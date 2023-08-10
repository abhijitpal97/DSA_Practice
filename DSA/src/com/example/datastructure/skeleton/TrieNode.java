package com.example.datastructure.skeleton;

public class TrieNode
{
    public TrieNode[] childrens;
    public boolean isEndOfWord;
    public int count;
	public int prefix;

    public TrieNode()
    {
        childrens = new TrieNode[26];
        isEndOfWord = false;
        count = 0;
        prefix = 0;
    }
}