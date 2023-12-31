package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/queue-reconstruction-by-height/description/

public class ReconstructQueue {
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people , (a,b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);

		List<int[]> list = new ArrayList<>();
		for(int[] p : people) list.add(p[1] , p);



		return list.toArray(new int[people.length][2]);
	}
}