package com.example.amazonpractice;
import java.util.*;

public class FindKthDecryptedString 
{
	public static void main(String[] args)
	{
		char ch = kThCharaterOfDecryptedString("ab12c3",20);
		System.out.println(ch);
	}

	public static char kThCharaterOfDecryptedString(String s, int k) 
	{
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<s.length() ; i++)
		{
			char ch = s.charAt(i);
			if(Character.isLetter(ch)) stack.push(ch);
			else if(Character.isDigit(ch))
			{
				int num = 0;
				while(Character.isDigit(s.charAt(i)))
				{
					num = num*10 + (s.charAt(i) - '0');
					i++;
					if(i== s.length()) break;
				}
				if(i < s.length())i--;
				String str = ""+stack.pop();
				while(!stack.isEmpty()) str = stack.pop()+str;

				for(int j=0;j<num;j++) sb.append(str);

				if(k-1<=str.length()) return str.charAt((int)(long)k-1);
			}
		}

		String str = sb.toString();
		if(k-1>str.length()) return ' ';
		return str.charAt((int)(long)k-1);
	}
}