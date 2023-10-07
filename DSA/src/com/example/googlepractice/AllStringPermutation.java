package com.example.googlepractice;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class AllStringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = allStringPermutation("ABC");
		System.out.println(result);
	}

	private static List<String> allStringPermutation(String str) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		function(str,"",list);
		return  list;
	}

	private static void function(String str, String ref, List<String> list) {
		// TODO Auto-generated method stub
		if(str.length()==0)
		{
			list.add(ref);
			return;
		}

		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			function(str.substring(0,i)+str.substring(i+1), ref+ch, list);
		}

	}

	// Alternate Using Freq
	public List<String> find_permutation(String S) {
		// Code here
		int n = S.length();
		int[] freq = new int[n];
		List<String> list = new ArrayList<>();
		function(S,n,freq,list,"");
		Collections.sort(list);
		return list;
	}

	void function(String str ,int length , int[] freq , List<String> list , String ref)
	{
		if(ref.length() == length)
		{
			if(! list.contains(ref)) list.add(ref);
			return;
		}

		for(int i=0;i<length;i++)
		{
			if(freq[i]==0)
			{
				char ch = str.charAt(i);
				freq[i]=1;
				function(str,length,freq,list,ref+ch);
				freq[i]=0;
			}
		}
	}

}
