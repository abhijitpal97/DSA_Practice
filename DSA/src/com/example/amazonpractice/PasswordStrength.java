package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/discuss/interview-question/1471459/Amazon-OA

public class PasswordStrength
{
	public static void main(String[] args)
	{
		int res = getPassWordStrength("thisisbeautiful");
		System.out.println(res);
		res = getPassWordStrength("hackerrank");
		System.out.println(res);
		res = getPassWordStrength("aeiou");
		System.out.println(res);
		res = getPassWordStrength("hck");
		System.out.println(res);
	}
	public static int getPassWordStrength(String password)
	{
		int count =0;
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		int vow = 0;
		int cons = 0;
		for(int i = 0 ; i<password.length(); i++)
		{
			char ch = password.charAt(i);
			if(vowels.contains(ch)) vow++;
			else cons++;

			if(vow>=1 && cons>=1)
			{
				count++;
				vow=0;
				cons=0;
			}
		}

		return count;
	}
}