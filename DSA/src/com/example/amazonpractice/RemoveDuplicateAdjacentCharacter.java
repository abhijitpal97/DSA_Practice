package com.example.amazonpractice;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/consecutive-elements2306/1

public class RemoveDuplicateAdjacentCharacter 
{
	public static String removeConsecutive(StringBuilder str) 
	{
		// Write your code here
		Stack<Character> stack = new Stack<>();

		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(stack.isEmpty()) 
			{
				stack.push(ch);
				continue;
			}
			else if(ch == stack.peek()) continue;
			stack.push(ch);

		}

		StringBuilder sb = new StringBuilder();

		while(! stack.isEmpty()) sb.insert(0 , stack.pop());

		return sb.toString();
	}
}
