package com.example.amazonpractice;

import java.util.*;

// If All Vertex as even Degree -> Euler Circuit
// If Exactly Two Vertex has odd Degree -> Euler Path

// https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1

public class EulerCircuitPath
{

	public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
	{
		// Code here
		int count = 0;

		for(int i = 0 ; i<V ; i++)
		{
			int eu = adj.get(i).size();
			if(eu%2 != 0) count++;
		}

		if(count == 0) return 2;
		if(count == 2) return 1;
		return 0;
	}
}