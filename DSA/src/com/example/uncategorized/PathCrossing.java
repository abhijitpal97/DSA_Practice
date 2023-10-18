package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/path-crossing/

public class PathCrossing {
	public boolean isPathCrossing(String path) {
		Set<String> set = new HashSet<>();
		int r = 0;
		int c = 0;
		set.add(r+"-"+c);

		for(char ch : path.toCharArray())
		{
			if(ch =='N')
			{
				r--;
				if(! set.add(r+"-"+c)) return true;
			}
			else if(ch =='S')
			{
				r++;
				if(! set.add(r+"-"+c)) return true;
			}
			else if(ch =='E')
			{
				c++;
				if(! set.add(r+"-"+c)) return true;
			}
			else if(ch =='W')
			{
				c--;
				if(! set.add(r+"-"+c)) return true;
			}
		}

		return false;
	}
}