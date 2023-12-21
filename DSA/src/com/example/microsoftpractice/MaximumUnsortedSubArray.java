package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// https://www.interviewbit.com/problems/359/

public class MaximumUnsortedSubArray {
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		List<Pair> list = new ArrayList<>();
		for(int i=0; i<A.size(); i++) list.add(new Pair(i , A.get(i)));

		Collections.sort(list , (a,b) -> a.num-b.num);

		ArrayList<Integer> res = new ArrayList<>();

		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).index != i) res.add(list.get(i).index);
		}

		if(res.isEmpty()) return new ArrayList<>(Arrays.asList(-1));

		Collections.sort(res);

		return new ArrayList<>(Arrays.asList(res.get(0) , res.get(res.size()-1)));
	}
}

class Pair
{
	int index;
	int num;

	Pair(int index , int num)
	{
		this.index = index;
		this.num = num;
	}
}
