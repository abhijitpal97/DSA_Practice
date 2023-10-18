package com.example.ciscopractice;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/

public class DecodeString {
	public String decodeString(String s) {
		Stack<Character> stack = new Stack<>();

		for(char ch : s.toCharArray())
		{
			if(ch !=']') stack.push(ch);
			else
			{
				StringBuilder sb = new StringBuilder();
				while(!stack.isEmpty() && Character.isLetter(stack.peek()))
				{
					sb.insert(0 , stack.pop());
				}
				stack.pop();

				StringBuilder dig = new StringBuilder();
				while(!stack.isEmpty() && Character.isDigit(stack.peek()))
				{
					dig.insert(0 , stack.pop());
				}
				int count = Integer.valueOf(dig.toString());

				while(count>0) 
				{
					for(char ch1 : sb.toString().toCharArray()) stack.push(ch1);
					count--;
				}
			}
		} 
		//System.out.println(stack);

		StringBuilder result = new StringBuilder();

		while(!stack.isEmpty())
		{
			result.insert(0,stack.pop());
		} 

		return result.toString();
	}
}