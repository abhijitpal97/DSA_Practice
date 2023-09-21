package com.example.gspractice;
import java.util.*;


public class IndexPair {

	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> res = indexPairs("abcdefcd", 
				new String[] {"cd" , "abc"});
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> indexPairs(String text, String words[]) {
		//  Write your code here.
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(String str : words)
		{
			function(text , str , list,0);
		}

		Collections.sort(list ,(a,b) -> a.get(0) - b.get(0));
		return list;
	}

	static void function(String text , String str , ArrayList<ArrayList<Integer>> list, int last)
	{
		if(text.length() == 0) return;

		int index = text.indexOf(str);
		if(index==-1) return;

		list.add(new ArrayList<>(Arrays.asList(last+index , last+index+str.length()-1)));
		function(text.substring(index+str.length()) , str , list , last+index+str.length());
	}
}
