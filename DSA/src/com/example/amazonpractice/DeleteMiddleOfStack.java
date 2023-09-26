package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

// https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

public class DeleteMiddleOfStack {
	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		// WRITE YOUR CODE HERE
		if(N == 0) return;
		if(N == 1) 
		{
			inputStack.pop();
			return;
		}
		Stack<Integer> stack = new Stack<>();
		int middle = (N-1) / 2;

		while(middle != 0)
		{
			stack.push(inputStack.pop());
			middle--;
		}
		inputStack.pop();
		while(! stack.isEmpty()) inputStack.push(stack.pop());
	}
}