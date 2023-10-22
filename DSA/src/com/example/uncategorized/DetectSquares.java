package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/detect-squares/

public class DetectSquares {
	List<int[]> coordinates;
	Map<String,Integer> counts;

	public DetectSquares() {
		coordinates = new ArrayList<>();
		counts = new HashMap<>();        
	}

	public void add(int[] point) {
		coordinates.add(point);
		String key = point[0]+"@"+point[1];
		counts.put(key , counts.getOrDefault(key , 0)+1);
	}

	public int count(int[] point) {
		int px = point[0];
		int py = point[1];
		int sum = 0;

		for(int[] coordinate : coordinates)
		{
			int x = coordinate[0];
			int y = coordinate[1];

			if(px == x || py == y || (Math.abs(px-x) != Math.abs(py-y))) continue;

			sum += counts.getOrDefault(x+"@"+py , 0)* counts.getOrDefault(px+"@"+y , 0);
		}

		return sum;
	}
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */