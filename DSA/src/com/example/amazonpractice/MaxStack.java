package com.example.amazonpractice;
import java.util.*;

// https://www.codingninjas.com/studio/problems/max-stack_985280?leftPanelTab=0
public class MaxStack {
	// Initialize MaxStack.
	Stack<Integer> normalStack;
	Stack<Integer> maxStack;

	public MaxStack() {
		// Write your code here.
		normalStack = new Stack<>();
		maxStack = new Stack<>();
	}

	public void specialPush(int value) {
		// Write your code here.
		normalStack.push(value);

		if(maxStack.isEmpty() || value>maxStack.peek()) maxStack.push(value);
	}

	// Return the popped value.
	public int specialPop() {
		// Write your code here.
		if(normalStack.isEmpty()) return -1;

		int value = normalStack.pop();
		if(maxStack.peek() == value) maxStack.pop();
		return value;
	}

	// Return the value at the top of stack.
	public int specialTop() {
		// Write your code here.
		if(normalStack.isEmpty()) return -1;
		return normalStack.peek();
	}

	// Return the maximum value in stack.
	public int specialMax() {
		// Write your code here.
		if(normalStack.isEmpty()) return -1;
		return maxStack.peek();
	}
}
