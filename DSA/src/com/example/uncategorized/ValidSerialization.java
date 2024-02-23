package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/

public class ValidSerialization {
	public boolean isValidSerialization(String preorder) {
		String[] data = preorder.split(",");

		int diff = 1;

		for(String str : data)
		{
			if(--diff < 0) return false;
			if(! str.equals("#")) diff +=2;
		}

		return diff == 0;
	}

	// Stack
	public boolean isValidSerializationStack(String preorder) {
		Stack<String> stack = new Stack<>();
		String[] res = preorder.split(",");

		for(String r : res)
		{
			while(r.equals("#") && !stack.isEmpty() && stack.peek().equals("#"))
			{
				stack.pop();
				if(stack.isEmpty()) return false;
				stack.pop();
			}
			stack.push(r);
		}

		return stack.size()==1 && stack.pop().equals("#");
	}
}