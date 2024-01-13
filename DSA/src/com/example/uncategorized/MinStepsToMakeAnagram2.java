package com.example.uncategorized;
// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii

import java.util.*;

public class MinStepsToMakeAnagram2 {
	public int minSteps(String s, String t) {
		Map<Character,Integer> sMap = new HashMap<>();
		Map<Character,Integer> tMap = new HashMap<>();
		Set<Character> sSet = new HashSet<>();

		for(char ch : s.toCharArray())
		{
			sMap.put(ch , sMap.getOrDefault(ch , 0)+1);
			sSet.add(ch);
		}
		for(char ch : t.toCharArray()) tMap.put(ch , tMap.getOrDefault(ch , 0)+1);

		for(char ch : sSet)
		{
			int sC = sMap.get(ch);
			if(tMap.containsKey(ch))
			{
				int tC = tMap.get(ch);
				if(sC == tC)
				{
					sMap.remove(ch);
					tMap.remove(ch);
				}
				else if(sC > tC)
				{
					tMap.remove(ch);
					sMap.put(ch , sC-tC);
				}
				else if(sC<tC)
				{
					sMap.remove(ch);
					tMap.put(ch , tC-sC);
				}
			}
		}

		int count = 0;

		for(Map.Entry<Character,Integer> m1 : sMap.entrySet()) count += m1.getValue();
		for(Map.Entry<Character,Integer> m1 : tMap.entrySet()) count += m1.getValue();

		return count;
	}
}