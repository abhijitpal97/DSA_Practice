package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/

class Person {
	int seat;
	int leaveTime;

	Person(int seat, int leaveTime) {
		this.seat = seat;
		this.leaveTime = leaveTime;
	}
}

public class SmallestChairRequired {
	public int smallestChair(int[][] times, int targetFriend) {

		int endTime = times[targetFriend][0];
		Arrays.sort(times , (a,b) -> a[0] - b[0]);
		Queue<Integer> available = new PriorityQueue<>();
		for(int i =0 ;i<times.length;i++) available.offer(i);

		Queue<Person> occupied = new PriorityQueue<>((a,b) -> a.leaveTime-b.leaveTime);


		int chair = 0;

		for(int i=0;i<times.length;i++)
		{
			int[] curr = times[i];

			while(!occupied.isEmpty() && occupied.peek().leaveTime<=curr[0])
			{
				available.offer(occupied.poll().seat);
			}

			if(endTime == curr[0])
			{
				return available.peek();
			}

			occupied.offer(new Person(available.poll() , curr[1]));
		}

		return 0;


	}
}