package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

public class ShortestSubstringWithAllCharacter {

	public static void main(String[] args)
	{
		String str = shortestSubstring("abbbcbbbbabbc");
		System.out.println(str);
	}
	public static String shortestSubstring(String s) {
		// Write your code here.
		Set<Character> set = new HashSet<>();
		for(char ch : s.toCharArray()) set.add(ch);
		int unique = set.size();

		Map<Character,Integer> map = new HashMap<>();
		int i = 0;
		int j = 1;
		String str = s;
		map.put(s.charAt(i) , 1);
		int count =1;
		while(j<s.length())
		{
			char ch = s.charAt(j);
			map.put(ch , map.getOrDefault(ch , 0)+1);
			if(map.get(ch) == 1) count++;

			while(count == unique)
			{
				if(str.length()>j-i+1)
				{
					str = s.substring(i , j+1);
				}
				map.put(s.charAt(i) , map.get(s.charAt(i))-1);
				if(map.get(s.charAt(i)) == 0) count--;
				i++;
			}
			j++;
		}

		return str;

	}
}