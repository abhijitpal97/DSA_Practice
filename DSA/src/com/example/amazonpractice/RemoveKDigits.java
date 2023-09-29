package com.example.amazonpractice;

// https://leetcode.com/problems/remove-k-digits/description/

public class RemoveKDigits {
	static int smallest = Integer.MAX_VALUE;

	public static void main(String[] args)
	{
		String str = removeKdigits("1432219" ,3);
		System.out.println(str);
	}

	public static String removeKdigits(String num, int k) {
		smallest = Integer.MAX_VALUE;
		if(num.length() == k) return "0";
		helper(num , "" , k);
		return String.valueOf(smallest);
	}

	static void helper(String str , String ref , int k)
	{
		if(k==0)
		{
			smallest = Math.min(smallest , Integer.valueOf(ref+str));
			return;
		}
		if(str.length() == 0) return;

		helper(str.substring(1) , ref+str.charAt(0) , k);
		helper(str.substring(1), ref , k-1);
	}
}