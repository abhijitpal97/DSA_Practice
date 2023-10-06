package com.example.microsoftpractice;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1

class TupleMeeting
{
	int start;
	int end;
	int index;

	TupleMeeting(int start , int end , int index)
	{
		this.start = start;
		this.end = end;
		this.index = index;
	}
}



public class MaxMeetingInRoom {
	public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		TupleMeeting[] tups = new TupleMeeting[N];

		for(int i = 0; i<N;i++)
		{
			tups[i] = new TupleMeeting(S[i] , F[i] , i+1);
		}
		Arrays.sort(tups , (a , b) -> a.end - b.end);

		TupleMeeting tp = tups[0];
		list.add(tp.index);

		for(int i = 1; i<tups.length;i++)
		{
			TupleMeeting curr = tups[i];
			if(curr.start>tp.end)
			{
				list.add(curr.index);
				tp = curr;
			}

		}
		Collections.sort(list);
		return list;
	}
}
