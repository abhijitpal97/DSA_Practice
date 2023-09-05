package com.example.amazonpractice;
import java.util.*;

public class KthLargestInStream {
	public static class Kthlargest {
		Queue<Integer> pq;
		int c ;
		Kthlargest(int k, int []arr) {
			pq = new PriorityQueue<>();
			for(int i = 0 ; i<arr.length; i++)
			{
				pq.offer(arr[i]);
			}
			c = k;
		}

		int add(int num) {
			pq.offer(num);
			while(pq.size()>c)
			{
				pq.poll();
			}

			return pq.peek();
		}
	};
}