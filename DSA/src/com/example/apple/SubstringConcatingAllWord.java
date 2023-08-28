package com.example.apple;

import java.util.*;

public class SubstringConcatingAllWord {
	public static void main(String[] args)
	{
		List<Integer> res = findSubstring("barfoothefoobarman", new String[] {"foo","bar"});
		System.out.println(res);
	}
	public static List<Integer> findSubstring(String s, String[] words) {
		List<String> list = new ArrayList<>();
		generateAllPermutations(words , list);
		List<Integer> result = new ArrayList<>();
		for(String str : list)
		{
			if(s.indexOf(str) != -1) 
			{
				int r = s.indexOf(str);
				if(! result.contains(r)) result.add(r);
			}
		}

		return result;
	}

	static void generateAllPermutations(String[] words , List<String> list)
	{
		function(words,"",list , 0 , new ArrayList<>());
		System.out.println(list);
	}

	private static void function(String[] words, String ref, List<String> list , int count , List<Integer> indexes) {
		// TODO Auto-generated method stub
		if(count == words.length)
		{
			list.add(ref);
			return;
		}

		for(int i=0;i<words.length;i++)
		{
			String str= words[i];
			if( !indexes.contains(i)) ref = ref+str;
			indexes.add(i);
			function(words, ref, list , count+1 , indexes);
			indexes.remove(indexes.size() - 1);
		}

	}
}