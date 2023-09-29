package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

// https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class ShortestSubstringWithAllCharacter {

	public static void main(String[] args)
	{
		String str = findSubString("aabcbcdbca");
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

	public static  String findSubString( String str) {
		Set<Character> set = new HashSet<>();
		for(char ch : str.toCharArray()) set.add(ch);

		int unique = set.size();
		int start = 0;
		int end = 0;
		int n = str.length();
		String res = "";
		int min=Integer.MAX_VALUE;

		Map<Character,Integer> map = new HashMap<>();

		while(end<n)
		{
			char ch = str.charAt(end);
			map.put(ch , map.getOrDefault(ch , 0)+1);

			while(map.size() == unique)
			{
				if(end-start+1<min)
				{
					res = str.substring(start , end+1);
					min = end-start+1;
				}

				char ch1 = str.charAt(start);
				map.put(ch1 , map.get(ch1)-1);
				if(map.get(ch1) == 0) map.remove(ch1);
				start++;
			}

			end++;
		}


		return res;
	}
}