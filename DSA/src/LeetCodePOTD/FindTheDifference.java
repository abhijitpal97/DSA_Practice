package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/find-the-difference/description/

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();

		for(char ch : t.toCharArray()) map.put(ch , map.getOrDefault(ch,0)+1);

		for(char ch : s.toCharArray())
		{
			map.put(ch , map.get(ch)-1);
			if(map.get(ch) == 0) map.remove(ch);
		}

		for(Map.Entry<Character,Integer> m1 : map.entrySet())
		{
			return m1.getKey();
		}

		return ' ';
	}
}