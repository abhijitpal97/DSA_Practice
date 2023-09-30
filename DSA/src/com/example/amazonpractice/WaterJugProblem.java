package com.example.amazonpractice;

// https://leetcode.com/problems/water-and-jug-problem/description/

public class WaterJugProblem {
	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		return jug1Capacity+jug2Capacity>=targetCapacity && targetCapacity%gcd(jug1Capacity , jug2Capacity) == 0;
	}

	int gcd(int jug1Capacity, int jug2Capacity)
	{
		while(jug2Capacity != 0)
		{
			int temp = jug2Capacity;
			jug2Capacity = jug1Capacity%jug2Capacity;
			jug1Capacity = temp;
		}
		return jug1Capacity;
	}
}