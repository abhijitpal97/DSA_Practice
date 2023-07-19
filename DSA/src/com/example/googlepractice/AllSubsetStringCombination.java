package com.example.googlepractice;

import java.util.*;

public class AllSubsetStringCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = combination("abc");
		System.out.println(list);

	}

	static List<String> combination(String str)
	{
		List<String> list = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();

		for(char ch : str.toCharArray()) map.put(ch , map.getOrDefault(ch, 0)+1);

		char[] chars = new char[map.size()];
		int[] count = new int[map.size()];
		char[] res = new char[str.length()];
		int index=0;
		for(Map.Entry<Character,Integer> m1 : map.entrySet())
		{
			chars[index] = m1.getKey();
			count[index] = m1.getValue();
			index++;
		}

		finalCombination(str , chars , count , res , 0 , map.size(), str.length(), list);

		return list;
	}

	private static void finalCombination(String str, char[] chars, 
			int[] count, char[] res, int curr, int size, int length,
			List<String> list) {

		if(curr == size) return;

		for(int i = 0 ; i<length;i++)
		{
			if(count[i] == 0) continue;

			count[i]--;
			res[curr] = str.charAt(i);
			addData(res , curr , list);
			finalCombination(str,chars,count,res,curr+1,size,length,list);
			count[i]++;
		}
	}

	static void addData(char[] result,
			int len, List<String> list)
	{
		String str = "";
		for (int i = 0; i <= len; i++)
		{
			str +=result[i];
		}
		list.add(str);
		
	}

}