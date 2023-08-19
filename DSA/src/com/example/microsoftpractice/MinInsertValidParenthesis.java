package com.example.microsoftpractice;

import java.util.Stack;

public class MinInsertValidParenthesis {

	public static void main(String[] args)
	{
		int res = minInsertions("(()))");
		System.out.println(res);
	}

	public static int minInsertions(String s) {
		int count = 0;
		Stack<Character> stack = new Stack<>();
		for(int i=0 ; i<s.length();i++)
		{
			char ch = s.charAt(i);
			if(ch =='(') 
			{
				stack.push(ch);
			}
			else
			{
				if(! stack.isEmpty() && stack.peek() == '(')
				{
					if(i < s.length()-1 && s.charAt(i+1) == ')')
					{
						i++;
						stack.pop();
					}
					else
					{
						count++;
						stack.pop();
					}
				}
				else
				{
					if(i < s.length()-1 && s.charAt(i+1) == ')')
					{
						i++;
						count++;
					}
					else count +=2; 

				}
			}
		}


		return count + (stack.size()*2);
	}
}