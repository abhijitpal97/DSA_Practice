package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/

public class MinStepsToMakeAnagram {

	public int minSteps(String s, String t) {
		Map<Character,Integer> sMap = new HashMap<>();
		Map<Character,Integer> tMap = new HashMap<>();

		for(char ch : s.toCharArray()) sMap.put(ch , sMap.getOrDefault(ch , 0)+1);
		for(char ch : t.toCharArray()) tMap.put(ch , tMap.getOrDefault(ch , 0)+1);

		for(Map.Entry<Character,Integer> m1 : sMap.entrySet())
		{
			char ch = m1.getKey();
			int count = m1.getValue();
			if(tMap.containsKey(ch))
			{
				int countT = tMap.get(ch);
				if(countT<=count) tMap.remove(ch);
				else tMap.put(ch , countT-count);
			}
		}

		int changeRequired = 0;
		for(Map.Entry<Character,Integer> m1 : tMap.entrySet())
		{
			changeRequired += m1.getValue();
		}

		return changeRequired;
	}
}