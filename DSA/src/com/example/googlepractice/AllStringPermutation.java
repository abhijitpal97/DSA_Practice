package com.example.googlepractice;

import java.util.*;

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
	
	

}
