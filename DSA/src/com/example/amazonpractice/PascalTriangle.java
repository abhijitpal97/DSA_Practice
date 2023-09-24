package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/pascals-triangle/

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(0 , new ArrayList<>(Arrays.asList(1)));
		if(numRows==1) return result;
		result.add(1 , new ArrayList<>(Arrays.asList(1,1)));
		if(numRows==2) return result;

		for(int i = 2 ; i<numRows ; i++)
		{
			List<Integer> prev = result.get(i-1); // 0 -> 1 , 1 -> 2 , 2 -> 1
			List<Integer> curr = new ArrayList<>(); // 1,3,3,1
			curr.add(0,1); 
			for(int j=1;j<i;j++)
			{
				curr.add(j , prev.get(j-1)+prev.get(j));
			}
			curr.add(i,1);
			result.add(i , curr);
		}

		return result;
	}
}