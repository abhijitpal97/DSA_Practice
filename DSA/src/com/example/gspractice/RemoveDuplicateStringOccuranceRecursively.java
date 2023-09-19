package com.example.gspractice;

public class RemoveDuplicateStringOccuranceRecursively
{
	public static void main(String[] args)
	{
		String str1 = "abc";
		String str2 = "abc";

		String res = removeAllStringOccurance(str1 , str2);
		System.out.println(res);
	}

	static String removeAllStringOccurance(String str1 , String str2)
	{
		String res = "";
		if(str1.length()<str2.length()) return str1;
		while(! str1.equals(res))
		{
			res = str1;
			str1 = removeDuplicate(str1 , str2);
		}

		return res;
	}


	static String removeDuplicate(String str1 , String str2)
	{
		int index = str1.indexOf(str2);
		if(index == -1) return str1;

		return str1.substring(0,index)+str1.substring(index+str2.length());
	}
}