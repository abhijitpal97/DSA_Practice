package com.example.amazonpractice;

import java.util.*;

public class BurgerWithoutWaste {
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		List<Integer> list = new ArrayList<>();
		function(tomatoSlices , cheeseSlices , 0 , 0 , list);

		return list;
	}

	void function(int tomato , int cheese , int jumbo , int small , List<Integer> list)
	{
		if(tomato == 0 && cheese == 0)
		{
			list.add(jumbo);
			list.add(small);
			return;
		}
		if(list.size() == 2) return;
		if(tomato<=0 && cheese != 0) return;
		if(tomato !=0 && cheese == 0) return;

		function(tomato-4 , cheese-1 , jumbo+1 , small , list);
		function(tomato-2 , cheese-1 , jumbo , small+1 , list);
	}

	// O(1) TC

	public List<Integer> numOfBurgersTC(int tomatoSlices, int cheeseSlices) {
		List<Integer> list = new ArrayList<>();

		if(tomatoSlices%2 != 0) return list;
		if(cheeseSlices*2 > tomatoSlices) return list;

		int extra = tomatoSlices - (cheeseSlices*2);
		int jumbo = extra/2;
		int small = cheeseSlices - jumbo;

		if(small<0) return list;

		list.add(jumbo);
		list.add(small);

		return list;
	}
}