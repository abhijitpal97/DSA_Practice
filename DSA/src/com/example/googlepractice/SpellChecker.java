package com.example.googlepractice;
import java.util.ArrayList;

import com.example.datastructure.skeleton.TrieNode;
// https://www.codingninjas.com/studio/problems/spell-checker_1376427

public class SpellChecker {
	// Function to insert string, 'STR' in the 'Trie'.
	public static void insert(TrieNode root, String str) {
		int i = 0;

		while (i < str.length()) {
			// Index of current character in 'Trie'.
			int index = str.charAt(i) - 'a';

			// Current character is not present.
			if (root.childrens[index] == null) {
				// Create a new node for the current character.
				root.childrens[index] = new TrieNode();
			}

			root = root.childrens[index];
			i++;
		}
		// Mark the end of the string.
		root.isEndOfWord = true;
	}

	// Function to find suggested correct spellings.
	public static void findSuggestions(TrieNode root, String possibleAnswer, ArrayList<String> res) {
		// String 'possibleAnswer' is present as a complete string.
		if (root.isEndOfWord == true) {
			res.add(possibleAnswer);
			return;
		}

		for (int i = 0; i < 26; i++) {
			// Character is present in the 'Trie'.
			if (root.childrens[i] != null) {
				// Append the character to the 'possibleAnswer'.
				possibleAnswer += (char)(i + 'a');

				findSuggestions(root.childrens[i], possibleAnswer, res);

				// Pop the last appended character.
				possibleAnswer = possibleAnswer.substring(0, possibleAnswer.length() - 1);
			}
		}
	}

	public static ArrayList<String> spellChecker(ArrayList<String> dictionary, String query) {
		// Creating root node of 'Trie'.
		TrieNode root = new TrieNode();

		for (int i = 0; i < dictionary.size(); i++) {
			insert(root, dictionary.get(i));
		}

		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < query.length(); i++) {
			// Index of current character in 'Trie'.
			int index = query.charAt(i) - 'a';

			// Current character is not present in the 'Trie'.
			if (root.childrens[index] == null) {
				// The substring of string 'query' before the current character is the longest
				// prefix to be searched in 'dictionary'.
				String prefixQuery = query.substring(0, i);
				findSuggestions(root, prefixQuery, result);

				return result;
			}
			root = root.childrens[index];
		}

		// The string 'query' is present in the 'Trie'.
		if (root.isEndOfWord == true) {
			return result;
		}

		// Find suggested correct spellings for 'query' with prefix as whole string.
		findSuggestions(root, query, result);
		return result;
	}
}