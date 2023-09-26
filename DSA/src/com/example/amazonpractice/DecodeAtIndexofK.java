package com.example.amazonpractice;

import java.util.Stack;

// https://leetcode.com/problems/decoded-string-at-index/

public class DecodeAtIndexofK {
	public static void main(String[] args)
	{
		String  res = decodeAtIndex("leet2code3", 10);
		System.out.println(res);
		res = decodeAtIndex("ha22", 5);
		System.out.println(res);
		res = decodeAtIndex("a2b3c4d5e6f7g8h9", 10);
		System.out.println(res);
	}
	public static String decodeAtIndex(String s, int k) {

		Stack<String> stack = new Stack<>();
		String str = "";
		int i = 0;
		while(!Character.isDigit(s.charAt(i)))
		{
			str +=s.charAt(i);
			i++;
			if(str.length()>=k) return String.valueOf(str.charAt(k-1));
		}
		stack.push(str);

		for(int j=i;j<s.length();j++)
		{
			if(Character.isDigit(s.charAt(j)))
			{
				int temp = Integer.valueOf(s.charAt(j) - '0');
				String curr = stack.pop();
				String res= "";
				for(int m=0;m<temp;m++)
				{
					res +=curr;
					if(res.length()>=k) return String.valueOf(res.charAt(k-1));
				}
				stack.push(res);
			}
			else
			{
				String curr = stack.pop();
				while(!Character.isDigit(s.charAt(j)))
				{
					curr +=s.charAt(j);
					j++;
					if(curr.length()>=k) return String.valueOf(curr.charAt(k-1));
				}
				j--;
				stack.push(curr);
			}
		}

		return String.valueOf(stack.peek().charAt(k-1));

	}

	// Partial Passed
	public static String decodeAtIndexPartial(String s, int k) {
		Stack<Character> stack  = new Stack<>();
		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			if(Character.isLetter(ch)) stack.push(ch);
			else
			{
				int index =Integer.valueOf(ch-'0');
				while(i+1<s.length() && Character.isDigit(s.charAt(i+1)))
				{
					index = index*10 + Integer.valueOf(s.charAt(i+1)-'0');
					i++;
				}

				StringBuilder sb = new StringBuilder();
				while(! stack.isEmpty())
				{
					sb.insert(0,stack.pop());
				}
				System.out.println(sb);
				int counter = 0;
				for(int j = 0 ; j<index ; j++)
				{
					for(char cu : sb.toString().toCharArray())
					{
						stack.push(cu);
						counter++;
						if(counter == k) return String.valueOf(cu);
					}
				}
			}
		}

		if(stack.size()>=k)
		{

			while(stack.size() != k) 
			{
				stack.pop();                
			}
			return String.valueOf(stack.peek());
		} 
		return "";

	}
}