package com.example.oracle;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/nearly-sorted_982937

// ZScaler

public class NearlySorted {
	public static int[] nearlySorted(int[] array, int n, int k) {
		// Write your code here.
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<=k;i++) pq.add(array[i]);

		int index = -1;
		for(int i = k+1 ; i<n ; i++)
		{
			index += 1;

			array[index]= pq.poll();
			pq.offer(array[i]);
		}

		while(! pq.isEmpty())
		{
			index++;
			array[index] = pq.poll();
		}

		return array;
	}
}