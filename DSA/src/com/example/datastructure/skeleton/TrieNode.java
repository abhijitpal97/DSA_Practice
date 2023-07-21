package com.example.datastructure.skeleton;

public class TrieNode
{
    public TrieNode[] childrens;
    public boolean isEndOfWord;

    public TrieNode()
    {
        childrens = new TrieNode[26];
        isEndOfWord = false;
    }
}

