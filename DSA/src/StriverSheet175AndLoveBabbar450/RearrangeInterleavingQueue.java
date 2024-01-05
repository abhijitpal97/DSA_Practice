package StriverSheet175AndLoveBabbar450;

import java.util.*;

// https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1

public class RearrangeInterleavingQueue {
	public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
		// code here
		int size = q.size();
		int[] arr = new int[size];
		int index = 0;
		for(int i=0;i<size/2;i++)
		{
			arr[index] = q.poll();
			index = index+2;
		}
		index=1;
		while(! q.isEmpty())
		{
			arr[index] = q.poll();
			index += 2;
		}

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<size;i++) list.add(arr[i]);

		return list;
	}
}

