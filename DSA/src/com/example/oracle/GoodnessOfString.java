package com.example.oracle;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/goodness-of-a-string_1266049

public class GoodnessOfString {

	public static void main(String[] args)
	{
		int res = goodnessOfString("[1,[2,3],[4,[5,6]]]");
		System.out.println(res);
	}

	public static int goodnessOfString(String s) {
		// Write your code here.
		Stack<int[]> stack = new Stack<>();
		int level =0;

		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '[')
			{
				level++;
				continue;
			}
			if(s.charAt(i) == ']')
			{
				level--;
				continue;
			}

			int num = 0;
			while(i<s.length() && Character.isDigit(s.charAt(i)))
			{
				num = num*10 + (s.charAt(i) - '0');
				i++;
			}
			if(s.charAt(i) != ',') i--;
			stack.push(new int[]{num , level});
		}

		int sum = 0;
		while(! stack.isEmpty())
		{
			int[] curr = stack.pop();
			sum += curr[0]*curr[1];
		}

		return sum;
	}
}