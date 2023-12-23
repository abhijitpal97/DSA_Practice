package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/my-calendar-i/description/

class CalanderPair
{
	int start;
	int end;

	CalanderPair(int start , int end)
	{
		this.start=start;
		this.end=end;
	}
}


public class MyCalendar {
	static List<CalanderPair> intervals;
	public MyCalendar() {
		intervals = new ArrayList<>();
	}

	public static void main(String[] args)
	{
		MyCalendar cal = new MyCalendar();
		System.out.println(cal.book(97,100));
		System.out.println(cal.book(33,51));
		System.out.println(cal.book(89,100));
		System.out.println(cal.book(83,100));
		System.out.println(cal.book(75,92));
		System.out.println(cal.book(76,95));
		System.out.println(cal.book(19,30));
		System.out.println(cal.book(53,63));
		System.out.println(cal.book(8,23));
		System.out.println(cal.book(18,37));
		System.out.println(cal.book(87,100));
		System.out.println(cal.book(83,100));
		System.out.println(cal.book(54,67));
		System.out.println(cal.book(35,48));
		System.out.println(cal.book(58,75));
		System.out.println(cal.book(70,89));
		System.out.println(cal.book(13,32));

	}

	public static boolean book(int start, int end) {
		if(! isValid(start , end)) return false;
		intervals.add(new CalanderPair(start,end));
		Collections.sort(intervals , (a,b) -> a.start-b.start);
		return true;
	}

	static boolean isValid(int start , int end)
	{
		for(CalanderPair p1 : intervals)
		{
			if(
					(start>=p1.start && start<p1.end) ||
					(end>p1.start && end<=p1.end)||
					(start<=p1.start && end>=p1.end)
					) return false;
		}

		return true;
	}
}