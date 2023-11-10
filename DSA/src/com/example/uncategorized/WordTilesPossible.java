package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/letter-tile-possibilities/description/

public class WordTilesPossible {
	public int numTilePossibilities(String tiles) {
		int n = tiles.length();
		boolean[] isVisited = new boolean[n];
		Set<String> set = new HashSet<>();
		function(set,"",tiles,n,isVisited);
		return set.size()-1;
	}

	void function(Set<String> set , String ref , String tiles , int n , boolean[] isVisited)
	{
		set.add(ref);
		for(int i=0;i<n;i++)
		{
			if(! isVisited[i])
			{
				isVisited[i] = true;
				function(set,ref+tiles.charAt(i),tiles,n,isVisited);
				isVisited[i] = false;
			}
		}
	}
}