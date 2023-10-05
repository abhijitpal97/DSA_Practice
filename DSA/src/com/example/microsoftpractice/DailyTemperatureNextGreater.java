package com.example.microsoftpractice;

import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/

public class DailyTemperatureNextGreater {
	public static void main(String[] args)
	{
		int[] temp = new int[] {73,74,75,71,69,72,76,73};
		int[] ans = dailyTemperatures(temp);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<temp.length ; i++)
		{
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[]  res = new int[n];
		Stack<Integer> stack = new Stack<>();

		for(int i = n-1;i>=0 ; i--)
		{
			if(stack.isEmpty())
			{
				stack.push(i);
				res[i] = 0;
			}
			else
			{
				if(temperatures[stack.peek()]>temperatures[i]) res[i] = stack.peek()- i;
				else
				{
					while(! stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
					{
						stack.pop();
						if(stack.isEmpty()) res[i] = 0;
					}
					if(! stack.isEmpty()) res[i] = stack.peek()- i;
				}

				stack.push(i);
			}
		}

		return res;
	}
}