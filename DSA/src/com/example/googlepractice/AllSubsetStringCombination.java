package com.example.googlepractice;

import java.util.*;

public class AllSubsetStringCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = combination("abca");
		System.out.println(list);

	}

	static List<String> combination(String str)
	{
		List<String> list = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();

		for(char ch : str.toCharArray()) map.put(ch , map.getOrDefault(ch, 0)+1);

		int[] count = new int[map.size()];

		int index=0;
		for(Map.Entry<Character,Integer> m1 : map.entrySet())
		{
			count[index] = m1.getValue();
			index++;
		}

		finalCombination(str , count ,  0 , map.size(), str.length(), list , "");

		return list;
	}

	private static void finalCombination(String str,
			int[] count, int curr, int size, int length,
			List<String> list,String ref) {

		if(curr == length) return;

		for(int i = 0 ; i<size;i++)
		{
			if(count[i] == 0) continue;

			count[i]--;
			ref += str.charAt(i);
			addData(ref , curr , list);
			finalCombination(str,count,curr+1,size,length,list,ref);
			count[i]++;
		}
	}

	static void addData(String result,
			int len, List<String> list)
	{
		String str = "";
		for (int i = 0; i < result.length(); i++)
		{
			str +=result.charAt(i);
		}
		list.add(str);

	}

}
