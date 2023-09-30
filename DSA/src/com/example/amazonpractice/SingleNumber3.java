package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/single-number-iii/description/

public class SingleNumber3 {
	public int[] singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums)
		{
			if(! set.add(i)) set.remove(i);
		}
		int[] res = new int[set.size()];
		int index=0;
		for(int i : set)
		{
			res[index] = i;
			index++;
		} 
		return res;
	}
}