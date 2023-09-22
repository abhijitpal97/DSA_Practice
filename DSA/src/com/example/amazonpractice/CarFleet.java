package com.example.amazonpractice;

import java.util.Arrays;

public class CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {
		int n = speed.length;
		double[][] data = new double[n][2];

		for(int i=0;i<n;i++)
		{
			data[i][0]=position[i]*1d;
			data[i][1]=((target-position[i])*1d)/speed[i];
		}

		Arrays.sort(data , (a,b) -> Double.compare(a[0],b[0]));

		int fleet = 1;
		double time = data[n-1][1];

		for(int i=n-2;i>=0;i--)
		{
			if(data[i][1]>time)
			{
				fleet++;
				time = data[i][1];
			}
		} 

		return fleet; 
	}
}