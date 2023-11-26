package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/description/

public class RandomizedSet {
	List<Integer> list;
	int index;
	public RandomizedSet() {
		list = new ArrayList<>();
		index=0;
	}

	public boolean insert(int val) {
		if(list.contains(val)) return false;
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if(list.contains(val))
		{
			list.remove(Integer.valueOf(val));
			return true;
		}
		return false;
	}

	public int getRandom() {
		Random rand = new Random();
		int random = list.get(rand.nextInt(list.size())); 
		return random;  
	}
}
