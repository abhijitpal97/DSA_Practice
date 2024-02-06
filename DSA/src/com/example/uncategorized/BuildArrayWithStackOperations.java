package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/build-an-array-with-stack-operations/description/

public class BuildArrayWithStackOperations {
	public List<String> buildArray(int[] target, int n) {
		List<String> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i=n;i>=1;i--)
		{
			stack.add(i);
		}

		int j = 0;
		while(j != target.length)
		{
			if(!stack.isEmpty())
			{
				if(stack.pop() == target[j]) 
				{
					list.add("Push");
					j++;
				}
				else
				{
					list.add("Push");
					list.add("Pop");
				}
			}
		}
		return list;

	}
}