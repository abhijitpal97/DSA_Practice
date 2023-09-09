package com.example.gspractice;

public class ReachableSourceToTarget {
	public static boolean isReachable(int startX, int startY, int endX, int endY) {
		// Write your code here.
		if(startX>endX || startY > endY) return false;
		if(startX==endX && startY == endY) return true;

		boolean y = isReachable(startX+startY , startY , endX , endY);
		boolean x = isReachable(startX , startY+startX , endX , endY);

		return y || x;
	}
}
