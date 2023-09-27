package com.example.amazonpractice;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class LongestSubstringwithKUniqueCharacter {
	public static int getLengthofLongestSubstring(int k, String s) {
		// Write your code here.
		int start = 0;
		int end = 0;
		int n = s.length();
		Map<Character,Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		while(end < n)
		{
			char ch = s.charAt(end);
			map.put(ch , map.getOrDefault(ch , 0)+1);

			if(map.size() > k)
			{
				while(map.size() != k)
				{
					char ch1 = s.charAt(start);
					map.put(ch1 , map.get(ch1)-1);
					if(map.get(ch1) == 0) map.remove(ch1);
					start++;
				}
				max = Math.max(max , end-start+1);
			}
			else max = Math.max(max , end-start+1);

			end++;
		}

		return max;
	}
}
