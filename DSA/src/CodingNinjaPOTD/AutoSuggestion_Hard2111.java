package CodingNinjaPOTD;
import java.util.* ;

import com.example.datastructure.skeleton.TrieNode;

import java.io.*; 

// https://www.codingninjas.com/studio/problems/auto-suggestion_3155171

public class AutoSuggestion_Hard2111 {
	static TrieNode root;

	public static ArrayList<ArrayList<String>> autoSuggestion (int n, String[] S, int l, String P)
	{
		// Write your code here
		root = new TrieNode();
		for(String str : S)
		{
			insert(str);
		}

		ArrayList<ArrayList<String>> result = new ArrayList<>();

		String word = "";
		for(int i=0;i<l;i++)
		{
			ArrayList<String> curr = new ArrayList<>();
			word += P.charAt(i);
			search(word , curr);
			result.add(curr);
		}

		return result;
	}

	static void search(String word , ArrayList<String> list)
	{
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			if(curr.childrens[ch-'a'] == null) return;
			curr = curr.childrens[ch-'a'];
		}

		dfs(curr , word , list);
	}

	static void dfs(TrieNode curr , String str , ArrayList<String> list)
	{
		if(list.size() == 3) return;
		if(curr.isEndOfWord) list.add(str);

		for(char ch = 'a' ; ch<='z';ch++)
		{
			if(curr.childrens[ch-'a'] != null)
			{
				String newWord = str+ch;
				dfs(curr.childrens[ch-'a'] , newWord , list);
			}
		}
	}

	static void insert(String str)
	{
		TrieNode curr = root;

		for(char ch : str.toCharArray())
		{
			if(curr.childrens[ch - 'a'] == null)
			{
				TrieNode newTrie = new TrieNode();
				curr.childrens[ch - 'a'] = newTrie;
			}
			curr = curr.childrens[ch - 'a'];
		}
		curr.isEndOfWord = true;
	}
}