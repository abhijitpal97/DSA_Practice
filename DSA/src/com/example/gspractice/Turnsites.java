package com.example.gspractice;

import java.util.*;

public class Turnsites
{
	public static void main(String[] args)
	{
		test(new int[] {0, 0, 1, 5}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 5});
		test(new int[] {0, 0, 5, 5}, new int[] {0,1,1,0}, new int[] {1, 0, 6, 5});
		test(new int[] {0, 0, 1, 1}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 3});
		test(new int[] {0, 0, 0, 0}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 3});
		test(new int[] {0, 0, 0, 0}, new int[] {0,0,0,0}, new int[] {0, 1, 2, 3});
		test(new int[] {0, 0, 1, 3, 10}, new int[] {0,1,1,1,0}, new int[] {2, 0, 1, 3, 10});
		test(new int[] {0, 1, 1, 3, 3}, new int[] {0, 1, 0, 0, 1}, new int[] {0,2,1,4,3});
	}

	private static void test(int[] time, int[] direction, int[] expected) {
		// TODO Auto-generated method stub
		int[] result = function(time , direction);
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		for(int i = 0 ; i<time.length ; i++)
		{
			sb.append(result[i]).append(" ");
			sb1.append(expected[i]).append(" ");
		}
		System.out.println("Actual - "+sb);
		System.out.println("Expected - "+sb1);

	}

	public static int[] function(int[] times, int[] directions) {
		// Store index of the cars
		List<Integer> entry = new LinkedList<>();
		List<Integer> exit = new LinkedList<>();
		for (int i = 0; i < times.length; i++) {
			if (directions[i] == 0) {
				entry.add(i);
			} else exit.add(i);
		}
		int curTime = -1;
		int prevDir = 1;
		int[] ret = new int[times.length];
		while (!entry.isEmpty() && !exit.isEmpty()) {
			int curEntry = entry.get(0);
			int curExit = exit.get(0);
			int curEnterTime = Math.max(times[curEntry], curTime);
			int curExitTime = Math.max(times[curExit], curTime);

			if (curEnterTime < curExitTime) {
				ret[curEntry] = curEnterTime;
				prevDir = 0;
				entry.remove(0);
				curTime = curEnterTime + 1;
			} else if (curExitTime < curEnterTime) {
				ret[curExit] = curExitTime;
				prevDir = 1;
				exit.remove(0);
				curTime = curExitTime + 1;
			} else {
				if (prevDir == 0) {
					ret[curEntry] = curEnterTime;
					entry.remove(0);
					curTime = curEnterTime + 1;
				} else {
					ret[curExit] = curExitTime;
					exit.remove(0);
					curTime = curExitTime + 1;                    
				}
			}
		}

		while (!entry.isEmpty()) {
			int curEntry = entry.remove(0);
			int curEnterTime = Math.max(times[curEntry], curTime);
			ret[curEntry] = curEnterTime;
			curTime = curEnterTime + 1;
		}

		while (!exit.isEmpty()) {
			int curExit = exit.remove(0);
			int curExitTime = Math.max(times[curExit], curTime);
			ret[curExit] = curExitTime;
			curTime = curExitTime + 1;
		}

		return ret;
	}
}