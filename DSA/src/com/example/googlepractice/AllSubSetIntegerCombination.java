package com.example.googlepractice;

import java.util.*;

public class AllSubSetIntegerCombination {

	public static void main(String[] args) {
		List<String> res = allsubsetCombination(new int[] {1,2,3,1});
		System.out.println(res);
	}

	private static List<String> allsubsetCombination(int[] is) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : is) map.put(i, map.getOrDefault(i, 0)+1);
		
		int[] counts = new int[map.size()];
		int[] res = new int[is.length];
		
		int index=0;
		for(Map.Entry<Integer, Integer> m1 : map.entrySet())
		{
			counts[index] = m1.getValue();
			index++;
		}
		
		List<String> list = new ArrayList<>();
		
		finalCombination(is , counts , res , 0 , map.size(),
				is.length , list);
		return list;
	}

	private static void finalCombination(int[] is, int[] counts,
			int[] res, int curr, int size, int length, List<String> list) {
		// TODO Auto-generated method stub
		
		if(curr == length) return;
		
		for(int i=0 ; i<size;i++)
		{
			if(counts[i] == 0) continue;
			
			counts[i]--;
			res[curr] = is[i];
			addData(res , curr,list);
			finalCombination(is , counts , res , curr+1 , size,
					length,list);
			counts[i]++;
		}
		
	}

	private static void addData(int[] res, int curr, List<String> list) {
		// TODO Auto-generated method stub
		String str = "";
		
		for(int i=0;i<=curr;i++)
		{
			str+=res[i]+"-";
		}
		list.add(str.substring(0,str.length()-1));
	}

}
