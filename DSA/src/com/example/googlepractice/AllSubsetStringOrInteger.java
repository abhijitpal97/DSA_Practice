package com.example.googlepractice;

import java.util.*;

public class AllSubsetStringOrInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = allSubsetString("ABC");
		List<String> res1 = allSubsetInteger(new int[] {1,2,3,4,5});
		System.out.println(res);
		System.out.println(res1);
	}
	
	private static List<String> allSubsetInteger(int[] array) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		for(int i=0;i<array.length;i++)
		{
			String subStr="";
			for(int j=i;j<array.length;j++)
			{
				subStr +=array[j];
				list.add(subStr);
				subStr +="-";
			}
		}
		
		return list;
	}

	private static List<String> allSubsetString(String str) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		for(int i=0;i<str.length();i++)
		{
			String subStr="";
			for(int j=i;j<str.length();j++)
			{
				subStr +=str.charAt(j);
				list.add(subStr);
			}
		}
		
		return list;
	}

}
