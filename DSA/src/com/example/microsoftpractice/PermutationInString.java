package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/permutation-in-string/

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {

		if(s1.length()>s2.length()) return false;
		Map<Character,Integer> map = new HashMap<>();
		for(char ch : s1.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);

		int start = 0;
		int end = 0 ;
		int remaining = s1.length();

		while(end<s2.length())
		{
			char ch = s2.charAt(end);

			if(map.containsKey(ch))
			{
				map.put(ch , map.get(ch)-1);
				if(map.get(ch)>=0) remaining--;
			}
			if(remaining == 0) return true;

			if(end-start+1>=s1.length())
			{
				char curr = s2.charAt(start);
				if(map.containsKey(curr))
				{
					map.put(curr , map.get(curr)+1);
					if(map.get(curr)>0) remaining++;
				}
				start++;
			}

			end++;
		}

		return false;
	}
}