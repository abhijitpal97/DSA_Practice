package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/iterator-for-combination/description/

public class CombinationIterator {
	List<String> list;
	int index = 0;
	public CombinationIterator(String characters, int combinationLength) {
		list = new ArrayList<>();
		generateAllCombination(characters , "", combinationLength , list);        
	}

	private void generateAllCombination(String str , String ref , int n , List<String> list)
	{
		if(ref.length() == n)
		{
			list.add(ref);
			return;
		}
		if(ref.length()>n) return;
		if(str.length() == 0) return;

		generateAllCombination(str.substring(1) , ref+str.charAt(0) , n , list);
		generateAllCombination(str.substring(1) , ref , n , list);
	}

	public String next() {
		String res = "";
		if(index<list.size())
		{
			res = list.get(index);
			index++;
			return res;
		}
		return res;
	}

	public boolean hasNext() {
		if(index==list.size()) return false;
		return true;
	}
}
