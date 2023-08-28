package LeetCodePOTD;

import java.util.*;

public class StackUsingQueue {
	Queue<Integer> q1;
	Queue<Integer> q2;

	public StackUsingQueue() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(int x) {
		while(! q1.isEmpty())
		{
			q2.offer(q1.poll());
		}
		q1.offer(x);
		while(! q2.isEmpty()) q1.offer(q2.poll());
	}

	public int pop() {
		if(q1.isEmpty()) return -1;
		return q1.poll();

	}

	public int top() {
		if(q1.isEmpty()) return -1;
		return q1.peek();
	}

	public boolean empty() {
		return q1.isEmpty();
	}
}
