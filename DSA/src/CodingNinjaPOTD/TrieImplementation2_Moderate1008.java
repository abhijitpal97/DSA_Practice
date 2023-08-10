package CodingNinjaPOTD;
import java.util.* ;

import com.example.datastructure.skeleton.TrieNode;

import java.io.*; 



public class TrieImplementation2_Moderate1008 {
	TrieNode root;
	public TrieImplementation2_Moderate1008() {
		// Write your code here.
		root = new TrieNode();
	}

	public void insert(String word) {
		// Write your code here.
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			if(curr.childrens[ch - 'a'] == null)
			{
				TrieNode newNode = new TrieNode();
				curr.childrens[ch - 'a'] = newNode;

			}
			curr = curr.childrens[ch - 'a'];
			curr.prefix++;
		}
		curr.isEndOfWord = true;
		curr.count++;
	}

	public int countWordsEqualTo(String word) {
		// Write your code here.
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			if(curr.childrens[ch - 'a'] == null) return 0;
			curr = curr.childrens[ch - 'a'];
		}

		if(curr.isEndOfWord) return curr.count;

		return 0 ;
	}

	public int countWordsStartingWith(String word) {
		// Write your code here.
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			if(curr.childrens[ch - 'a'] == null) return 0;
			curr = curr.childrens[ch - 'a'];
		}

		return curr.prefix;
	}

	public void erase(String word) {
		// Write your code here.
		TrieNode curr = root;

		for(char ch : word.toCharArray())
		{
			curr = curr.childrens[ch - 'a'];
			curr.prefix--;
		}
		if(curr.count>1) curr.count--;
		else
		{
			curr.isEndOfWord=false;
			curr.count=0;
		}
	}

}
