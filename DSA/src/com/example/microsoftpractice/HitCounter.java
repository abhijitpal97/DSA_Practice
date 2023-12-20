package com.example.microsoftpractice;

import java.util.*;

// https://www.geeksforgeeks.org/design-a-hit-counter/

public class HitCounter
{
	static Queue<Long> queue = new PriorityQueue<>();

	public static void main(String[] args)
	{

		System.out.println(HitCounter.getHits(0));
		HitCounter.hit(1);
		HitCounter.hit(2);
		HitCounter.hit(3);
		System.out.println(HitCounter.getHits(4));
		HitCounter.hit(300);
		System.out.println(HitCounter.getHits(300));
		System.out.println(HitCounter.getHits(301));
	}


	static void hit(long timestamp)
	{
		queue.offer(timestamp);
	}

	static int getHits(long timestamp)
	{
		checkFiveMins(timestamp);

		return queue.size();
	}

	static void checkFiveMins(long last)
	{
		long thres = last-300;


		while(! queue.isEmpty() && queue.peek() <= thres) queue.poll();
	}
}