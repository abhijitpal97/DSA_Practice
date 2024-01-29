package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/implement-queue-using-stacks/submissions/1159995645/

public class MyQueueUsingStack_2901 {
	Stack<Integer> s1;
	Stack<Integer> s2;
	public MyQueueUsingStack_2901() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void push(int x) {
		while(! s1.isEmpty()) s2.push(s1.pop());
		s1.push(x);
		while(! s2.isEmpty()) s1.push(s2.pop());
	}

	public int pop() {
		if(!s1.isEmpty()) return s1.pop();
		return -1;
	}

	public int peek() {
		if(! s1.isEmpty()) return s1.peek();
		return -1;
	}

	public boolean empty() {
		return s1.isEmpty();
	}
}