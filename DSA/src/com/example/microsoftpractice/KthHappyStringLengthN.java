package com.example.microsoftpractice;

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

public class KthHappyStringLengthN {
	static boolean flag = false;
	static String res = "";
	static int count = 0;

	public static void main(String[] args)
	{
		getHappyString(3, 9);
		System.out.println(res);
	}

	public static String getHappyString(int n, int k) {
		flag = false;
		res = "";
		count=0;
		function(n , k , "" , ' ');
		return res;
	}

	static void function(int n , int  k , String str , char ch)
	{
		if(flag) return;
		if(n == 0) 
		{
			count++;
			if(k == count) 
			{
				flag = true;
				res = str;
			}
			return;
		}

		if(ch == 'a')
		{
			function(n-1 , k , str+'b' , 'b');
			function(n-1 , k , str+'c' , 'c');
			return;
		}

		else if(ch == 'b')
		{
			function(n-1 , k , str+'a' , 'a');
			function(n-1 , k , str+'c' , 'c');
			return;
		}

		else if(ch == 'c')
		{
			function(n-1 , k , str+'a' , 'a');
			function(n-1 , k , str+'b' , 'b');
			return;
		}
		else
		{
			function(n-1 , k , str+'a' , 'a');
			function(n-1 , k , str+'b' , 'b');
			function(n-1 , k , str+'c' , 'c');
			return;
		}
	}
}