package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/task-scheduler/description/

class SchedulePair
{
	int task;
	int time;

	SchedulePair(int task , int time)
	{
		this.task = task;
		this.time = time;
	}
}



public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		Map<Character,Integer> map = new HashMap<>();
		for(char ch : tasks) map.put(ch , map.getOrDefault(ch , 0)+1);

		Queue<Integer> processQ = new PriorityQueue<>((a,b) -> b-a);
		Queue<SchedulePair> waitingQ = new LinkedList<>();
		processQ.addAll(map.values());

		int time = 0;
		while(! processQ.isEmpty() || ! waitingQ.isEmpty())
		{
			while(! waitingQ.isEmpty())
			{
				if(waitingQ.peek().time == time) processQ.offer(waitingQ.poll().task);
				else break;
			}

			if(! processQ.isEmpty())
			{
				int occur = processQ.poll();
				int left = occur-1;
				if(left>0) waitingQ.offer(new SchedulePair(left , time+n+1));
			}
			time++;
		}

		return time;
	}
}
