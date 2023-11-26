package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/min-stack/description/

public class MinStack {
	Stack<Integer> stack;
	Map<Integer,Integer> map;
	public MinStack() {
		stack = new Stack<>();
		map = new TreeMap<>();
	}

	public void push(int val) {
		stack.push(val);
		map.put(val , map.getOrDefault(val,0)+1);
	}

	public void pop() {
		if(! stack.isEmpty())
		{
			int r = stack.pop();
			map.put(r , map.get(r)-1);
			if(map.get(r) == 0) map.remove(r);
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		if(stack.isEmpty()) return -1;
		for(Map.Entry<Integer,Integer> m1 : map.entrySet()) return m1.getKey();
		return -1;
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */