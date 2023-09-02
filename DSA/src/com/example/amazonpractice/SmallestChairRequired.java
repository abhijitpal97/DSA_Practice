package com.example.amazonpractice;

import java.util.*;

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

		int targetTime = times[targetFriend][0];
		Arrays.sort(times , (a,b) -> a[0] - b[0]);
		int chair = 0;
		Queue<Integer> pq = new PriorityQueue<>();
		Queue<Person> occupied = new PriorityQueue<>((x, y) -> x.leaveTime - y.leaveTime);

		for(int i = 0 ; i<times.length ; i++)
		{
			int[] curr = times[i];

			while(! pq.isEmpty() && occupied.peek().leaveTime<=curr[0])
			{
				int seat = occupied.poll().seat;
				pq.add(seat);
			}

			if(curr[0] == targetTime) return !pq.isEmpty()? pq.peek() : chair++;

			occupied.add(new Person(!pq.isEmpty() ? pq.poll() : chair++ , curr[1]));
		}

		return 0;
	}
}