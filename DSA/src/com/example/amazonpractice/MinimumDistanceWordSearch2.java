package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 
// https://www.codingninjas.com/studio/problems/shortest-word-distance-ii_1459114

public class MinimumDistanceWordSearch2 {

	public static int minimumDistance(String[] arr, String book1, String book2) {
		// Write your code here
		int b1I = -1;
		int b2I = -1;
		int minD = Integer.MAX_VALUE;
		for(int i=0;i<arr.length; i++)
		{
			if(arr[i].equals(book1))
			{
				b1I = i;
				if(b2I != -1) minD = Math.min(minD , Math.abs(b1I-b2I));
			}

			else if(arr[i].equals(book2))
			{
				b2I = i;
				if(b1I != -1) minD = Math.min(minD , Math.abs(b1I-b2I));
			}
		}

		if(minD == Integer.MAX_VALUE) return -1;
		return minD;
	}   
}