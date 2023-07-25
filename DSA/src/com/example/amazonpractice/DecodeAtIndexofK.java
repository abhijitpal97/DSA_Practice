package com.example.amazonpractice;

import java.util.Stack;

public class DecodeAtIndexofK {
	public static void main(String[] args)
	{
		String res = decodeAtIndex("a2b3c4d5e6f7g8h9", 10);
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
}